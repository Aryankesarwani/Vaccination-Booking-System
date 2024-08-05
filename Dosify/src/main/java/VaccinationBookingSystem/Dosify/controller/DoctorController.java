package VaccinationBookingSystem.Dosify.controller;

import VaccinationBookingSystem.Dosify.Service.DoctorService;
import VaccinationBookingSystem.Dosify.dto.requestDTO.DoctorRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.DoctorResponseDto;
import VaccinationBookingSystem.Dosify.exceptions.CenterNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto){
        try {
            DoctorResponseDto doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
            return  new ResponseEntity(doctorResponseDto,HttpStatus.CREATED);
        } catch (CenterNotExistException e) {
            return  new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
