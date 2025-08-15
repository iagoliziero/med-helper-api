package med.helper.api.doctor;

import med.helper.api.address.DataAddress;

public record RegisterDataDoctor(String name, String email, String crm, Specialty specialty, DataAddress address) {
}
