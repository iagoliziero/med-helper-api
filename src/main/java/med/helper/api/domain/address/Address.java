package med.helper.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class Address {
    private String street;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    private String number;
    private String complement;

    public Address(DataAddress address) {
        this.street = address.street();
        this.neighborhood = address.neighborhood();
        this.zipCode = address.zipCode();
        this.city = address.city();
        this.state = address.state();
        this.number = address.number();
        this.complement = address.complement();
    }

    public void updateInfos(DataAddress data) {
        if(data.street() != null) {
            this.street = data.street();
        }

        if(data.neighborhood() != null) {
            this.neighborhood = data.neighborhood();
        }

        if(data.zipCode() != null) {
            this.zipCode = data.zipCode();
        }

        if(data.state() != null) {
            this.state = data.state();
        }

        if(data.number() != null) {
            this.number = data.number();
        }

        if(data.complement() != null) {
            this.complement = data.complement();
        }

        if(data.complement() != null) {
            this.complement = data.complement();
        }
    }
}
