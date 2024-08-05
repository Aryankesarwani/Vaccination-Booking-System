package VaccinationBookingSystem.Dosify.Service;

import VaccinationBookingSystem.Dosify.Enum.VaccineType;
import VaccinationBookingSystem.Dosify.Model.Dose2;
import VaccinationBookingSystem.Dosify.Model.User;

public interface Dose2Service
{
    Dose2 dose2Appointment(User user, VaccineType vaccineType);
}
