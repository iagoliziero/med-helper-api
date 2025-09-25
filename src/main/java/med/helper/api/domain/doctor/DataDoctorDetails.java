package med.helper.api.domain.doctor;

import med.helper.api.domain.address.Address;
import med.helper.api.domain.doctor.enums.Specialty;

public record DataDoctorDetails(Long id, String name, String email, String crm, String phone, Specialty specialty, Address address) {
    public DataDoctorDetails(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpecialty(), doctor.getAddress());
    }
}
