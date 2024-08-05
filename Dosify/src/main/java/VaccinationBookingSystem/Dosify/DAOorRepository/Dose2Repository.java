package VaccinationBookingSystem.Dosify.DAOorRepository;

import VaccinationBookingSystem.Dosify.Model.Dose1;
import VaccinationBookingSystem.Dosify.Model.Dose2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dose2Repository extends JpaRepository<Dose2,Integer> {

}
