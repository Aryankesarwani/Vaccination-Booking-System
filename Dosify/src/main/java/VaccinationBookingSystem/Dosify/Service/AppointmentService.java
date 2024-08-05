package VaccinationBookingSystem.Dosify.Service;

import VaccinationBookingSystem.Dosify.dto.requestDTO.AppointmentRequest;
import VaccinationBookingSystem.Dosify.dto.responseDTO.AppointmentResponseDto;
import VaccinationBookingSystem.Dosify.exceptions.DoctorNotFoundException;
import VaccinationBookingSystem.Dosify.exceptions.UserNotFoundException;

public interface AppointmentService {
    public AppointmentResponseDto bookAppointment(AppointmentRequest appointmentRequest) throws UserNotFoundException, DoctorNotFoundException;
}
