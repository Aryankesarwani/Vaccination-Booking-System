package VaccinationBookingSystem.Dosify.dto.requestDTO;

import VaccinationBookingSystem.Dosify.Enum.CenterType;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterRequestDto {

    String name;

    String location;

    CenterType centerType;
}
