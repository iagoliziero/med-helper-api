package med.helper.api.address;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class Address {
    private String street;
    private String neighborhood;
    String zipCode;
    String city;
    String state;
    String number;
    String complement;
}
