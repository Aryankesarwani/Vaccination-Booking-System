package VaccinationBookingSystem.Dosify.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CertificateResponseDto {

    String name;
    String CertificateId;
}
