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
import VaccinationBookingSystem.Dosify.exceptions.UserNotFoundException;
import VaccinationBookingSystem.Dosify.transformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;
    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequest appointmentRequest) throws UserNotFoundException, DoctorNotFoundException {
        Optional<User> optionaluser = userRepository.findById(appointmentRequest.getUserId());
        if(!optionaluser.isPresent()){
            throw new UserNotFoundException("User Not Exist!");
        }
        Optional<Doctor> optionaldoctor = doctorRepository.findById(appointmentRequest.getDoctorId());
        if(!optionaldoctor.isPresent()){
            throw new DoctorNotFoundException("Doctor Not Exist!");
        }
        User user = optionaluser.get();
        Doctor doctor = optionaldoctor.get();

        if(appointmentRequest.getDoseNo() == DoseNo.DOSE_1){
            Dose1 dose1 = dose1Service.dose1Appointment(user,appointmentRequest.getVaccineType());
            user.setIs_dose1_taken(true);
            user.setDose1(dose1);

        }
        else if (appointmentRequest.getDoseNo() == DoseNo.DOSE_2) {
            Dose2 dose2 = dose2Service.dose2Appointment(user,appointmentRequest.getVaccineType());
            user.setIs_dose2_taken(true);
            user.setDose2(dose2);

        }
        else{

        }
    }
}
