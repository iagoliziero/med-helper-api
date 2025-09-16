package med.helper.api.dto;

import med.helper.api.address.Address;
import med.helper.api.enums.Specialty;
import med.helper.api.models.doctor.Doctor;

public record DataDoctorDetails(Long id, String name, String email, String crm, String phone, Specialty specialty, Address address) {
    public DataDoctorDetails(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpecialty(), doctor.getAddress());
    }
}
