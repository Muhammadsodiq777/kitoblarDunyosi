package uz.pdp.bookserviice.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "attachment_content")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttachmentContent extends BaseEntity {

    @OneToOne
    Attachment attachment;
    byte[] data;
}
