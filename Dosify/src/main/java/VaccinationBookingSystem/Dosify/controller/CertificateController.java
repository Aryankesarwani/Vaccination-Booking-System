package VaccinationBookingSystem.Dosify.controller;

import VaccinationBookingSystem.Dosify.Model.Certificate;
import VaccinationBookingSystem.Dosify.Service.CertificateService;
import VaccinationBookingSystem.Dosify.dto.requestDTO.CertificateRequestDto;
import VaccinationBookingSystem.Dosify.exceptions.DoseNotTakenException;
import VaccinationBookingSystem.Dosify.exceptions.UserNotFoundException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/Certificate")
public class CertificateController {
    @Autowired
    CertificateService certificateService;

    @PostMapping(value = "/generatePDF",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createCertificate(@RequestBody CertificateRequestDto certificateRequestDto) throws UserNotFoundException, MessagingException, DoseNotTakenException {
        return new ResponseEntity(certificateService.createCertificate(certificateRequestDto), HttpStatus.CREATED);
    }
}
