package med.helper.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.helper.api.domain.address.DataAddress;

public record UpdateDataDoctor(@NotNull Long id, String name, String phone, DataAddress address) {
}
