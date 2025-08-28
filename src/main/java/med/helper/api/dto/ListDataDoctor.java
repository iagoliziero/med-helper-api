package med.helper.api.dto;

import med.helper.api.enums.Specialty;
import med.helper.api.models.doctor.Doctor;

public record ListDataDoctor(String name, String email, String crm, Specialty specialty) {
    public ListDataDoctor(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
