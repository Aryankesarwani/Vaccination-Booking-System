package VaccinationBookingSystem.Dosify.dto.requestDTO;

import VaccinationBookingSystem.Dosify.Enum.DoseNo;
import VaccinationBookingSystem.Dosify.Enum.VaccineType;
import VaccinationBookingSystem.Dosify.Model.VaccinationCenter;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentRequest {

    DoseNo doseNo;

    Integer userId;

    Integer doctorId;

    VaccineType vaccineType;
}
