package VaccinationBookingSystem.Dosify.Service.Impl;

import VaccinationBookingSystem.Dosify.DAOorRepository.CenterRepository;
import VaccinationBookingSystem.Dosify.Model.VaccinationCenter;
import VaccinationBookingSystem.Dosify.Service.CenterService;
import VaccinationBookingSystem.Dosify.dto.requestDTO.CenterRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.CenterResponseDto;
import VaccinationBookingSystem.Dosify.transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    CenterRepository centerRepository;
    @Override
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto) {
        VaccinationCenter center = CenterTransformer.CenterRequestToCenter(centerRequestDto);
        VaccinationCenter savedCenter = centerRepository.save(center);
        return CenterTransformer.CenterToCenterResponse(savedCenter);
    }
}
