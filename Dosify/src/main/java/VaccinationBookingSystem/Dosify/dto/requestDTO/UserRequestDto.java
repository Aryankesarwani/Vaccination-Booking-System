package VaccinationBookingSystem.Dosify.dto.requestDTO;

import VaccinationBookingSystem.Dosify.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {
    String name;

    int age;

    String emailId;

    String contact;

    Gender gender;

}
