package VaccinationBookingSystem.Dosify.Service;

import VaccinationBookingSystem.Dosify.Enum.VaccineType;
import VaccinationBookingSystem.Dosify.Model.Dose1;
import VaccinationBookingSystem.Dosify.Model.User;

public interface Dose1Service {


    Dose1 dose1Appointment(User user,VaccineType vaccineType);
}
