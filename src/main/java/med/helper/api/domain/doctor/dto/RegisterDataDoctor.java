package med.helper.api.domain.doctor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.helper.api.domain.address.dto.DataAddress;
import med.helper.api.domain.doctor.enums.Specialty;

public record RegisterDataDoctor(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String phone,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull Specialty specialty,
        @NotNull @Valid DataAddress address) {
}
