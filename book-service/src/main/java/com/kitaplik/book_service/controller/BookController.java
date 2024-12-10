package com.kitaplik.book_service.controller;

import com.kitaplik.book_service.dto.BookDto;
import com.kitaplik.book_service.dto.BookIdDto;
import com.kitaplik.book_service.dto.BookRequestDto;
import com.kitaplik.book_service.repository.BookRepository;
import com.kitaplik.book_service.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;


@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable(value = "isbn") @NotEmpty String isbn){
        logger.info("Kitap --" + isbn +  "--  isbn numarasi ile istendi");
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable(value = "id") @NotEmpty String id){
        return ResponseEntity.ok(bookService.findBookDetailsById(id));
    }

    @PostMapping
    public ResponseEntity<BookDto> addBook(@RequestBody @NotEmpty BookRequestDto bookRequestDto){
        BookDto bookDto = bookRequestDto.getBookDto();
        BookIdDto bookIdDto = bookRequestDto.getBookIdDto();

        return ResponseEntity.ok(bookService.addBook(bookDto, bookIdDto));
    }

    @DeleteMapping("{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable @NotEmpty String isbn){
        bookService.deleteBook(isbn);
        return ResponseEntity.ok().build();
    }

}
