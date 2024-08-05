package VaccinationBookingSystem.Dosify.transformer;

import VaccinationBookingSystem.Dosify.Model.User;
import VaccinationBookingSystem.Dosify.dto.requestDTO.UserRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.UserResponseDto;

public class UserTransformer {
    public static User UserRequestDtotoUser(UserRequestDto userRequestDto){
        return User.builder().name(userRequestDto.getName())
                .age(userRequestDto.getAge())
                .emailId(userRequestDto.getEmailId())
                .contact(userRequestDto.getContact())
                .gender(userRequestDto.getGender())
                .build();
    }
    public  static UserResponseDto UsertoUserResponseDto(User user){
        return UserResponseDto.builder().name(user.getName())
                        .message("Congrats! you have registered on Dosify").build();

        }
}
