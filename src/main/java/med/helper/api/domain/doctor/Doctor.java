package med.helper.api.domain.doctor;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import med.helper.api.domain.address.Address;
import med.helper.api.domain.doctor.dto.RegisterDataDoctor;
import med.helper.api.domain.doctor.dto.UpdateDataDoctor;
import med.helper.api.domain.doctor.enums.Specialty;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private Boolean active;

    public Doctor(RegisterDataDoctor data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void infosUpdate(@Valid UpdateDataDoctor data) {
        if(data.name() != null) {
            this.name = data.name();
        }

        if(data.phone() != null) {
            this.phone = data.phone();
        }

        if(data.address() != null) {
            this.address.updateInfos(data.address());
        }
    }

    public void inactive() {
        this.active = false;
    }
}
