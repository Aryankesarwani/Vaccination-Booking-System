package VaccinationBookingSystem.Dosify.dto.responseDTO;

import VaccinationBookingSystem.Dosify.Enum.CenterType;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponseDto {

    String name;

    String emailId;

    String contact;

    CenterResponseDto centerResponseDto;

}
