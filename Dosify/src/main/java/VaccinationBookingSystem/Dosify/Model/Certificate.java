package VaccinationBookingSystem.Dosify.Model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String recipientName;

//    LocalDate vaccinationDate;

    @CreationTimestamp
    LocalDate issueDate;

    String certificateNumber;

    @OneToOne
    @JoinColumn
    User user;

}
