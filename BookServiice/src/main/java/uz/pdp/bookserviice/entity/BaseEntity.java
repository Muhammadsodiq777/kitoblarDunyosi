package uz.pdp.bookserviice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp created_at;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updated_at;

    @CreatedBy
    @Column(name = "created_by_id")
    private Long createdBy;

    @LastModifiedBy
    @Column(name = "updated_by_id")
    private Long updatedBy;

}
