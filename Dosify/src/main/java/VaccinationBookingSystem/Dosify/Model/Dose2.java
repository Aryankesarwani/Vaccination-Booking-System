package VaccinationBookingSystem.Dosify.Model;

import VaccinationBookingSystem.Dosify.Enum.VaccineType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Dose2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "doseId")
    String doseId;

    @Enumerated(EnumType.STRING)
    VaccineType vaccineType;

    @CreationTimestamp
    Date vaccinationDate;

    @OneToOne
    @JoinColumn
    User user;
}
