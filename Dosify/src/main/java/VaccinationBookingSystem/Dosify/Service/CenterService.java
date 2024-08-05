package VaccinationBookingSystem.Dosify.Service;

import VaccinationBookingSystem.Dosify.dto.requestDTO.CenterRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.CenterResponseDto;
import org.springframework.stereotype.Service;


@Service
public interface CenterService {
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto);
}
