package med.helper.api.dto;

import jakarta.validation.constraints.NotNull;
import med.helper.api.address.DataAddress;

public record UpdateDataDoctor(@NotNull Long id, String name, String phone, DataAddress address) {
}
