package VaccinationBookingSystem.Dosify.Model;

import VaccinationBookingSystem.Dosify.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "user")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "email",unique = true,nullable = false)
    String emailId;

    @Column(name = "contact",unique = true,nullable = false)
    String contact;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "is_dose1_taken")
    Boolean is_dose1_taken;
    
    @Column(name = "is_dose2_taken")
    Boolean is_dose2_taken;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Appointment> appointments = new ArrayList<>();

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Dose1 dose1;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Dose2 dose2;
}
