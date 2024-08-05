package VaccinationBookingSystem.Dosify.transformer;

import VaccinationBookingSystem.Dosify.Model.Appointment;
import VaccinationBookingSystem.Dosify.dto.requestDTO.AppointmentRequest;
import VaccinationBookingSystem.Dosify.dto.responseDTO.AppointmentResponseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentTransformer {
    public static Appointment AppointmentDtoToAppointment(AppointmentRequest appointmentRequest){
        return Appointment.builder().
    }
    public static AppointmentResponseDto AppointmentToResponseDto(Appointment appointment){

    }
}
