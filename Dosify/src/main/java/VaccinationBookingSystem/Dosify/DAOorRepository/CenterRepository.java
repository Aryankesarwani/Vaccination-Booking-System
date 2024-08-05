package VaccinationBookingSystem.Dosify.DAOorRepository;

import VaccinationBookingSystem.Dosify.Model.VaccinationCenter;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<VaccinationCenter, Integer>{
}
