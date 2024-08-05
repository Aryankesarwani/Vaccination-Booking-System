package VaccinationBookingSystem.Dosify.Service.Impl;

import VaccinationBookingSystem.Dosify.DAOorRepository.CenterRepository;
import VaccinationBookingSystem.Dosify.DAOorRepository.DoctorRepository;
import VaccinationBookingSystem.Dosify.Model.Doctor;
import VaccinationBookingSystem.Dosify.Model.VaccinationCenter;
import VaccinationBookingSystem.Dosify.Service.DoctorService;
import VaccinationBookingSystem.Dosify.dto.requestDTO.DoctorRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.CenterResponseDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.DoctorResponseDto;
import VaccinationBookingSystem.Dosify.exceptions.CenterNotExistException;
import VaccinationBookingSystem.Dosify.transformer.CenterTransformer;
import VaccinationBookingSystem.Dosify.transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    CenterRepository centerRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotExistException {
        Optional<VaccinationCenter> optionalCenter =  centerRepository.findById(doctorRequestDto.getCenterId());
        if(!optionalCenter.isPresent())
            throw new CenterNotExistException("Invalid Center Id!");


        VaccinationCenter center = optionalCenter.get();
//        dto to entity
        Doctor savedDoctor = doctorRepository.save(DoctorTransformer.DoctorRequestDtoTODoctor(doctorRequestDto));
        savedDoctor.setVaccinationCenter(center);
//        add doctor to current list of doctors at           center
        center.getDoctors().add(savedDoctor);
        centerRepository.save(center); // saves both center and doctor

//        prepare response dto


        CenterResponseDto centerResponseDto = CenterTransformer.CenterToCenterResponse(center);

        return DoctorTransformer.DoctorToDoctorResponseDto(savedDoctor);

    }
}
