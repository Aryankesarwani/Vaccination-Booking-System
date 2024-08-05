package VaccinationBookingSystem.Dosify.dto.responseDTO;

import VaccinationBookingSystem.Dosify.Enum.DoseNo;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDto {

    String userName;
    String appointmentNo;

    Date appointmentDate;

    DoseNo doseNo;

    CenterResponseDto centerResponseDto;

    String doctorName;



}
