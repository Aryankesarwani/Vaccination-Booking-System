package VaccinationBookingSystem.Dosify.transformer;

import VaccinationBookingSystem.Dosify.DAOorRepository.DoctorRepository;
import VaccinationBookingSystem.Dosify.DAOorRepository.UserRepository;
import VaccinationBookingSystem.Dosify.DosifyApplication;
import VaccinationBookingSystem.Dosify.Enum.VaccineType;
import VaccinationBookingSystem.Dosify.Model.Appointment;
import VaccinationBookingSystem.Dosify.Model.Doctor;
import VaccinationBookingSystem.Dosify.Model.User;
import VaccinationBookingSystem.Dosify.Model.VaccinationCenter;
import VaccinationBookingSystem.Dosify.dto.requestDTO.AppointmentRequest;
import VaccinationBookingSystem.Dosify.dto.responseDTO.AppointmentResponseDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.CenterResponseDto;
import VaccinationBookingSystem.Dosify.exceptions.DoctorNotFoundException;
import VaccinationBookingSystem.Dosify.exceptions.UserNotFoundException;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.print.Doc;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@UtilityClass
public class AppointmentTransformer {

    public static Appointment AppointmentDtoToAppointment(Doctor doctor, User user, AppointmentRequest appointmentRequest) throws UserNotFoundException, DoctorNotFoundException {

        return Appointment.builder()
                .user(user)
                .doctor(doctor)
                .appointmentNumber(UUID.randomUUID().toString())
                .doseNo(appointmentRequest.getDoseNo())
                .build();
    }
    public static AppointmentResponseDto AppointmentToResponseDto(Appointment appointment, VaccineType vaccineType){
        CenterResponseDto centerResponseDto = CenterTransformer.CenterToCenterResponse(appointment.getDoctor().getVaccinationCenter());
        return AppointmentResponseDto.builder()
                .appointmentNo(appointment.getAppointmentNumber())
                .userName(appointment.getUser().getName())
                .doseNo(appointment.getDoseNo())
                .appointmentDate(appointment.getDateOfAppointment())
                .doctorName(appointment.getDoctor().getName())
                .vaccineType(vaccineType)
                .centerResponseDto(centerResponseDto)
                .build();

    }
}
