package VaccinationBookingSystem.Dosify.Service.Impl;

import VaccinationBookingSystem.Dosify.DAOorRepository.UserRepository;
import VaccinationBookingSystem.Dosify.Model.User;
import VaccinationBookingSystem.Dosify.Service.UserService;
import VaccinationBookingSystem.Dosify.dto.requestDTO.UpdateRequestDto;
import VaccinationBookingSystem.Dosify.dto.requestDTO.UserRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.UserResponseDto;
import VaccinationBookingSystem.Dosify.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        //convert request dto to entity
//        User user = new User();
//        user.setName(userRequestDto.getName());
//        user.setAge(userRequestDto.getAge());
//        user.setEmailId(userRequestDto.getEmailId());
//        user.setContact(userRequestDto.getContact());
//        user.setGender(userRequestDto.getGender());
        User user = UserTransformer.UserRequestDtotoUser(userRequestDto);

        //save the user in db
        User savedUser = userRepository.save(user);

        //entity to response Dto
        return UserTransformer.UsertoUserResponseDto(savedUser);

    }

    @Override
    public UserResponseDto get_By_Email(String email) {
        User user = userRepository.findByEmailId(email);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setMessage("User '"+userResponseDto.getName()+"' found successfully.");
        return userResponseDto;
    }
    @Override
    public UserResponseDto getByID(Integer id) {
        Optional<User> user = userRepository.findById(id);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.get().getName());
        userResponseDto.setMessage("User '"+userResponseDto.getName()+"' found successfully.");
        return userResponseDto;
    }


    @Override
    public UserResponseDto UpdateUser(String contact, UpdateRequestDto updateRequestDto) {
        System.out.println(updateRequestDto.getEmail());
        userRepository.UpdateUser(contact, updateRequestDto.getName(),updateRequestDto.getEmail(),updateRequestDto.getAge(),updateRequestDto.getGender());
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(updateRequestDto.getName());
        userResponseDto.setMessage("User '"+updateRequestDto.getName()+"' Updated Successfully");

        return userResponseDto;
    }



}
