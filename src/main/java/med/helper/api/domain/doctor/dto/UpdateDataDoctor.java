package med.helper.api.domain.doctor.dto;

import jakarta.validation.constraints.NotNull;
import med.helper.api.domain.address.dto.DataAddress;

public record UpdateDataDoctor(@NotNull Long id, String name, String phone, DataAddress address) {
}
