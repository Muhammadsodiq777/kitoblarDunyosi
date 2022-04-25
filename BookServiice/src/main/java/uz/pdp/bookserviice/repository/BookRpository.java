package uz.pdp.bookserviice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bookserviice.entity.BookEntity;

public interface BookRpository extends JpaRepository<BookEntity, Long> {
}
