package VaccinationBookingSystem.Dosify.controller;

import VaccinationBookingSystem.Dosify.Service.CenterService;
import VaccinationBookingSystem.Dosify.dto.requestDTO.CenterRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.CenterResponseDto;
import VaccinationBookingSystem.Dosify.transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/center")
public class CenterController {
    @Autowired
    CenterService centerService;

    @PostMapping("/addCenter")
    public ResponseEntity addVaccinationCenter(@RequestBody CenterRequestDto centerRequestDto){
        CenterResponseDto centerResponseDto = centerService.addCenter(centerRequestDto);
        return new ResponseEntity<>(centerResponseDto, HttpStatus.CREATED);
    }
}
