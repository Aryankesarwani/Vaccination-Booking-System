package VaccinationBookingSystem.Dosify.Service;

import VaccinationBookingSystem.Dosify.Model.Doctor;
import VaccinationBookingSystem.Dosify.dto.requestDTO.DoctorRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.DoctorResponseDto;
import VaccinationBookingSystem.Dosify.exceptions.CenterNotExistException;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService {
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotExistException;
}
