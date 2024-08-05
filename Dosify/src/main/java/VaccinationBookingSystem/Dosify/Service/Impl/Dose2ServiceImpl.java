package VaccinationBookingSystem.Dosify.Service.Impl;

import VaccinationBookingSystem.Dosify.Enum.VaccineType;
import VaccinationBookingSystem.Dosify.Model.Dose2;
import VaccinationBookingSystem.Dosify.Model.User;
import VaccinationBookingSystem.Dosify.Service.Dose2Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose2ServiceImpl implements Dose2Service {
    @Override
    public Dose2 dose2Appointment(User user, VaccineType vaccineType) {
        return Dose2.builder().doseId(UUID.randomUUID().toString())
                .user(user).vaccineType(vaccineType).build();
    }
}
