package VaccinationBookingSystem.Dosify.transformer;

import VaccinationBookingSystem.Dosify.Model.Doctor;
import VaccinationBookingSystem.Dosify.dto.requestDTO.DoctorRequestDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.CenterResponseDto;
import VaccinationBookingSystem.Dosify.dto.responseDTO.DoctorResponseDto;

public class DoctorTransformer {
    public static Doctor DoctorRequestDtoTODoctor(DoctorRequestDto doctorRequestDto){
        return Doctor.builder().name(doctorRequestDto.getName())
                .emailId(doctorRequestDto.getEmailId())
                .contact(doctorRequestDto.getContact())
                .age(doctorRequestDto.getAge())
                .gender(doctorRequestDto.getGender())
                .build();
    }
    public static DoctorResponseDto DoctorToDoctorResponseDto(Doctor doctor){
        CenterResponseDto centerResponseDto = CenterTransformer.CenterToCenterResponse(doctor.getVaccinationCenter());
        return DoctorResponseDto.builder().name(doctor.getName())
                .contact(doctor.getContact())
                .emailId(doctor.getEmailId())
                .centerResponseDto(centerResponseDto).build();

    }
}
