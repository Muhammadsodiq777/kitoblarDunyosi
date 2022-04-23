package uz.pdp.bookserviice.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "attachments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Attachment extends BaseEntity {

    String name;
    String contentType;
    Long size;
}
