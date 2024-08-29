package VaccinationBookingSystem.Dosify.transformer;

import VaccinationBookingSystem.Dosify.Model.Certificate;
import VaccinationBookingSystem.Dosify.dto.requestDTO.CertificateRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.CertificateResponseDto;

public class CertificateTransformer {

    public static Certificate dtoToentity(CertificateRequestDto certificateRequestDto){
        return Certificate.builder()
                .recipientName(certificateRequestDto.getName()).build();
    }

    public static CertificateResponseDto entityTodto(Certificate savedCertificate) {
        return CertificateResponseDto.builder()
                .name(savedCertificate.getRecipientName())
                .CertificateId(savedCertificate.getCertificateNumber())
                .build();
    }
}
