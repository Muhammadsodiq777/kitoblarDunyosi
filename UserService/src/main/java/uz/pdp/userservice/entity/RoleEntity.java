package uz.pdp.userservice.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.pdp.userservice.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
public class RoleEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
