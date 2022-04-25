package uz.pdp.bookserviice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.bookserviice.entity.BookEntity;
import uz.pdp.bookserviice.repository.BookRpository;
import uz.pdp.feinclient.book.dto.BookDTO;
import uz.pdp.feinclient.book.fein_client.GetAllBook;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRpository bookRpository;
    public List<BookEntity> getAllBooks() {
        List<BookEntity> all = bookRpository.findAll();
        return all;
    }
}
