package VaccinationBookingSystem.Dosify.dto.requestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CertificateRequestDto {
    String name;

    String email;
}
