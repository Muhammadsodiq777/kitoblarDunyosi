package uz.pdp.feinclient.book.fein_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import uz.pdp.feinclient.book.dto.BookDTO;

import java.util.List;

@FeignClient(value = "book")
public interface GetAllBook {

    @GetMapping("/api/book/all")
    List<BookDTO> getAllBook();
}
