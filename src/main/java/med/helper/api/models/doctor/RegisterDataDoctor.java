package med.helper.api.models.doctor;

import med.helper.api.address.DataAddress;
import med.helper.api.enums.Specialty;

public record RegisterDataDoctor(String name, String email, String crm, Specialty specialty, DataAddress address) {
}
