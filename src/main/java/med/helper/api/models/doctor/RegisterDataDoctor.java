package med.helper.api.models.doctor;

import med.helper.api.address.DataAddress;

public record RegisterDataDoctor(String name, String email, String crm, Specialty specialty, DataAddress address) {
}
