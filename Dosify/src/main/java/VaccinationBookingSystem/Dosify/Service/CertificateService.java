package VaccinationBookingSystem.Dosify.Service;

import VaccinationBookingSystem.Dosify.dto.requestDTO.CertificateRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.CertificateResponseDto;
import VaccinationBookingSystem.Dosify.exceptions.DoseNotTakenException;
import VaccinationBookingSystem.Dosify.exceptions.UserNotFoundException;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public interface CertificateService {
    public CertificateResponseDto createCertificate(CertificateRequestDto certificateRequestDto) throws UserNotFoundException, DoseNotTakenException, MessagingException;
}
