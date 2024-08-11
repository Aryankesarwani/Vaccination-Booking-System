package VaccinationBookingSystem.Dosify.controller;

import VaccinationBookingSystem.Dosify.Service.AppointmentService;
import VaccinationBookingSystem.Dosify.dto.requestDTO.AppointmentRequest;
import VaccinationBookingSystem.Dosify.dto.responseDTO.AppointmentResponseDto;
import VaccinationBookingSystem.Dosify.exceptions.DoctorNotFoundException;
import VaccinationBookingSystem.Dosify.exceptions.DoseNotTakenException;
import VaccinationBookingSystem.Dosify.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
        @Autowired
        AppointmentService appointmentService;
        @PostMapping("/book")
        AppointmentResponseDto bookAppointment(@RequestBody AppointmentRequest appointmentRequest) throws UserNotFoundException, DoctorNotFoundException, DoseNotTakenException {
                return appointmentService.bookAppointment(appointmentRequest);
        }
}
