package VaccinationBookingSystem.Dosify.Service.Impl;

import VaccinationBookingSystem.Dosify.DAOorRepository.UserRepository;
import VaccinationBookingSystem.Dosify.Model.Certificate;
import VaccinationBookingSystem.Dosify.Model.User;
import VaccinationBookingSystem.Dosify.Service.CertificateService;
import VaccinationBookingSystem.Dosify.dto.requestDTO.CertificateRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.CertificateResponseDto;
import VaccinationBookingSystem.Dosify.exceptions.DoseNotTakenException;
import VaccinationBookingSystem.Dosify.exceptions.UserNotFoundException;
import VaccinationBookingSystem.Dosify.transformer.CertificateTransformer;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public CertificateResponseDto createCertificate(CertificateRequestDto certificateRequestDto) throws UserNotFoundException, DoseNotTakenException, MessagingException {
        User user = userRepository.findByEmailId(certificateRequestDto.getEmail());
        if(user == null) {
            throw new UserNotFoundException("User not Registered!...");
        }
        if(user.getIs_dose1_taken() == null){
            throw new DoseNotTakenException("Dose 1 not taken by "+user.getName());
        }
        if(user.getIs_dose2_taken()==null){
            throw new DoseNotTakenException("Dose 2 not taken by "+user.getName());
        }
        Certificate certificate = CertificateTransformer.dtoToentity(certificateRequestDto);
        certificate.setCertificateNumber(UUID.randomUUID().toString());
        certificate.setUser(user);
        user.setCertificate(certificate);

        User savedUser = userRepository.save(user);// save both user and certificate
        Certificate savedCertificate = savedUser.getCertificate();

        sendMail(user.getEmailId(),generateCertificate(savedCertificate));
        return CertificateTransformer.entityTodto(savedCertificate);
    }
    public ByteArrayInputStream generateCertificate(Certificate certificate){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try{
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Certificate of Vaccination").setTextAlignment(TextAlignment.CENTER).setFontSize(24));
            document.add(new Paragraph("This certifies that").setTextAlignment(TextAlignment.CENTER).setFontSize(16));
            document.add(new Paragraph(certificate.getRecipientName()).setTextAlignment(TextAlignment.CENTER).setFontSize(18).setBold());
            document.add(new Paragraph("has successfully Vaccinated").setTextAlignment(TextAlignment.CENTER).setFontSize(16));
            document.add(new Paragraph("on").setTextAlignment(TextAlignment.CENTER).setFontSize(16));
            document.add(new Paragraph(String.valueOf(certificate.getIssueDate())).setTextAlignment(TextAlignment.CENTER).setFontSize(16));
            document.add(new Paragraph("Certificate Number: ").setTextAlignment(TextAlignment.CENTER).setFontSize(24));
            document.add(new Paragraph(certificate.getCertificateNumber()).setTextAlignment(TextAlignment.CENTER).setFontSize(18).setBold());
            document.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    public void sendMail(String email, ByteArrayInputStream certificate) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject("Your Certificate of Vaccination");
        helper.setText("Congratulations! Please find attached your certificate of vaccination.");

        // Attach the certificate PDF
        helper.addAttachment("Certificate.pdf", new ByteArrayResource(certificate.readAllBytes()));

        javaMailSender.send(message);
    }



}
