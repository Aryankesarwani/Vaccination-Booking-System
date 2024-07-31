package VaccinationBookingSystem.Dosify.DAOorRepository;

import VaccinationBookingSystem.Dosify.Enum.Gender;
import VaccinationBookingSystem.Dosify.Model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailId(String emailId);

    User findByContact(String contact);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name = :name, u.emailId = :emailId, u.age = :age, u.gender = :gender WHERE u.contact = :contact")
    void UpdateUser( @Param("contact") String contact, @Param("name") String name, @Param("emailId") String email,
                    @Param("age") int age, @Param("gender") Gender gender);
}
