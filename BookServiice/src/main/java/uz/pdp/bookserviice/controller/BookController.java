package uz.pdp.bookserviice.controller;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.html.HTMLHeadElement;
import uz.pdp.bookserviice.entity.BookEntity;
import uz.pdp.bookserviice.service.BookService;
import uz.pdp.feinclient.book.dto.BookDTO;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity getAllBook(){
        List<BookEntity> list = bookService.getAllBooks();
        return ResponseEntity.ok(list);
    }
}
