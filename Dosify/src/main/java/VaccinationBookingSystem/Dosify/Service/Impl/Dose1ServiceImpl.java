package VaccinationBookingSystem.Dosify.Service.Impl;

import VaccinationBookingSystem.Dosify.Enum.VaccineType;
import VaccinationBookingSystem.Dosify.Model.Dose1;
import VaccinationBookingSystem.Dosify.Model.User;
import VaccinationBookingSystem.Dosify.Service.Dose1Service;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class Dose1ServiceImpl implements Dose1Service {

    @Override
    public Dose1 dose1Appointment( User user,VaccineType vaccineType) {
//        user.setIs_dose1_taken(true);

        return Dose1.builder()
                .doseId(UUID.randomUUID().toString())
                .vaccineType(vaccineType)
                .user(user).build();
    }
}
