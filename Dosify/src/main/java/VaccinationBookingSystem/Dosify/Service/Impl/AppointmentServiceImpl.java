package VaccinationBookingSystem.Dosify.Service.Impl;

import VaccinationBookingSystem.Dosify.DAOorRepository.DoctorRepository;
import VaccinationBookingSystem.Dosify.DAOorRepository.UserRepository;
import VaccinationBookingSystem.Dosify.Enum.DoseNo;
import VaccinationBookingSystem.Dosify.Model.*;
import VaccinationBookingSystem.Dosify.Service.AppointmentService;
import VaccinationBookingSystem.Dosify.Service.Dose1Service;
import VaccinationBookingSystem.Dosify.Service.Dose2Service;
import VaccinationBookingSystem.Dosify.dto.requestDTO.AppointmentRequest;
import VaccinationBookingSystem.Dosify.dto.responseDTO.AppointmentResponseDto;
import VaccinationBookingSystem.Dosify.exceptions.DoctorNotFoundException;
import VaccinationBookingSystem.Dosify.exceptions.DoseNotTakenException;
import VaccinationBookingSystem.Dosify.exceptions.UserNotFoundException;
import VaccinationBookingSystem.Dosify.transformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    UserRepository userRepository;
    @Autowired DoctorRepository doctorRepository;
    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;

    @Autowired
    private JavaMailSender emailSender;
    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequest appointmentRequest) throws UserNotFoundException, DoctorNotFoundException, DoseNotTakenException {

        Optional<User> optionaluser = userRepository.findById(appointmentRequest.getUserId());
        System.out.println("yha aaya exception");
        if(!optionaluser.isPresent()){
            System.out.println("ye qu nhi aa rha");
            throw new UserNotFoundException("User Not Exist!");
        }
        User user = optionaluser.get();
        Optional<Doctor> optionaldoctor = doctorRepository.findById(appointmentRequest.getDoctorId());
        if(!optionaldoctor.isPresent()){
            throw new DoctorNotFoundException("Doctor Not Exist!");
        }
        Doctor doctor = optionaldoctor.get();

        Appointment appointment = AppointmentTransformer.AppointmentDtoToAppointment(doctor,user,appointmentRequest);


        if(appointmentRequest.getDoseNo() == DoseNo.DOSE_1){
            Dose1 dose1 = dose1Service.dose1Appointment(appointment.getUser(),appointmentRequest.getVaccineType());
            appointment.getUser().setIs_dose1_taken(true);
            appointment.getUser().setDose1(dose1);

        }
        else if (appointmentRequest.getDoseNo() == DoseNo.DOSE_2) {
            Dose2 dose2 = dose2Service.dose2Appointment(appointment.getUser(),appointmentRequest.getVaccineType());
            appointment.getUser().setIs_dose2_taken(true);
            appointment.getUser().setDose2(dose2);

        }
        else{
                throw new DoseNotTakenException("Dose1 not has been taken!");
        }

//        appointment.setAppointmentNumber(UUID.randomUUID().toString());


//        doctor.getAppointments().add(appointment);
        user.getAppointments().add(appointment);

        String text = "Congrats!! "+user.getName()+"you have booked your appointment " +appointmentRequest.getDoseNo()+"successfully!!";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("aryan.kesarwani1801@gmail.com");
        message.setTo(user.getEmailId());
        message.setSubject("Appointment Booked!!");
        message.setText(text);
        emailSender.send(message);


        User SavedUser = userRepository.save(appointment.getUser()); // saves dose1,dose2 and appointment
        Appointment savedAppointment = SavedUser.getAppointments().get(SavedUser.getAppointments().size() - 1);
        doctor.getAppointments().add(savedAppointment);
        appointment.setDateOfAppointment(savedAppointment.getDateOfAppointment());

        //prepare response dto

        return AppointmentTransformer.AppointmentToResponseDto(savedAppointment,appointmentRequest.getVaccineType());

    }
}
