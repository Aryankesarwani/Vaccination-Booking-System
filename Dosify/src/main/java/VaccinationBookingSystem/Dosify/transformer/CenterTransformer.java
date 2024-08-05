package VaccinationBookingSystem.Dosify.transformer;

import VaccinationBookingSystem.Dosify.Model.VaccinationCenter;
import VaccinationBookingSystem.Dosify.dto.requestDTO.CenterRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.CenterResponseDto;
import lombok.Builder;
import org.springframework.http.ResponseEntity;

@Builder
public class CenterTransformer {
    public static VaccinationCenter CenterRequestToCenter(CenterRequestDto centerRequestDto){

        return VaccinationCenter.builder()
                .name(centerRequestDto.getName())
                .location(centerRequestDto.getLocation())
                .centerType(centerRequestDto.getCenterType())
                .build();
    }

    public static CenterResponseDto CenterToCenterResponse(VaccinationCenter savedCenter) {
        return  CenterResponseDto.builder()
                .name(savedCenter.getName())
                .location(savedCenter.getLocation())
                .centerType(savedCenter.getCenterType())
                .build();
    }
}
