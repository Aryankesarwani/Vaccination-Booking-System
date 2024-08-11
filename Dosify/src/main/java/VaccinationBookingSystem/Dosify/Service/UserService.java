package VaccinationBookingSystem.Dosify.Service;

import VaccinationBookingSystem.Dosify.Model.User;
import VaccinationBookingSystem.Dosify.dto.requestDTO.UpdateRequestDto;
import VaccinationBookingSystem.Dosify.dto.requestDTO.UserRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserResponseDto addUser(UserRequestDto userRequestDto);

    UserResponseDto get_By_Email(String email);

    UserResponseDto UpdateUser(String contact, UpdateRequestDto updateRequestDto);

    UserResponseDto getByID(Integer id);
}
