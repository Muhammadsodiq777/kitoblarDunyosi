package uz.pdp.userservice.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum BookStatus {
    PRESENT(0),
    NOT_PRESENT(1),
    SOON_WILL_BE_PRESENT(3);

    int index = 0;
}
