package uz.pdp.userservice.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum UserRole {
    SUPER_ADMIN(0),
    ADMIN(1),
    USER(2);

    int index = 0;
}
