package VaccinationBookingSystem.Dosify.controller;
import VaccinationBookingSystem.Dosify.Service.UserService;
import VaccinationBookingSystem.Dosify.dto.requestDTO.UpdateRequestDto;
import VaccinationBookingSystem.Dosify.dto.requestDTO.UserRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserRequestDto userRequestDto){   //response entity is used to send status code created by u like 201,201,...
        UserResponseDto userResponseDto =  userService.addUser(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    //find by email
    @GetMapping("/find_by_email")
    public UserResponseDto get_By_Email(@RequestParam String email){
        return userService.get_By_Email(email);
        //return new ResponseEntity<>(userResponseDto,HttpStatus.ACCEPTED);
    }

    @GetMapping("find_by_id")
    public UserResponseDto getByID(@RequestParam Integer id){
        return userService.getByID(id);
    }

    //update the name of user based on mobile number

    @PutMapping("/updateUser")
    public UserResponseDto updateUser(@RequestParam String contact,@RequestBody UpdateRequestDto updateRequestDto){
        return userService.UpdateUser(contact, updateRequestDto);
    }
    //make Api for finding all user have not taken dose 1
    //all user who have taken dose1 but not dose2
    //all who are fully vaccinated
    //all male user who have not taken single vaccine
}
