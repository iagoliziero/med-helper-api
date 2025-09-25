package med.helper.api.domain.doctor;

import med.helper.api.domain.doctor.enums.Specialty;

public record ListDataDoctor(Long id, String name, String email, String crm, Specialty specialty) {
    public ListDataDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
