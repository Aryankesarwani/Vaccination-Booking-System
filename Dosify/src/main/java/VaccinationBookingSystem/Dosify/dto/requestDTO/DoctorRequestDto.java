package VaccinationBookingSystem.Dosify.dto.requestDTO;

import VaccinationBookingSystem.Dosify.Enum.Gender;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorRequestDto {

    int centerId;

    String name;

    int age;

    String emailId;

    String contact;

    Gender gender;

}
