package com.kitaplik.book_service.service;

import com.kitaplik.book_service.dto.BookDto;
import com.kitaplik.book_service.dto.BookIdDto;
import com.kitaplik.book_service.exception.BookNotFoundException;
import com.kitaplik.book_service.exception.TheBookAlreadyExistException;
import com.kitaplik.book_service.model.Book;
import com.kitaplik.book_service.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    /*
     *  veritabanına kayıtlı tüm kitapları getiren ve veritananının boş olma
     *  durumuna göre kontrol yapan metod
     * */

    public List<BookDto> getAllBooks() {
        List<BookDto> books = bookRepository.findAll()
                .stream()
                .map(BookDto::convertToBookDto)
                .collect(Collectors.toList());

        if (books.isEmpty()) {
            throw new BookNotFoundException("Veritabanında Kitap Bulunamadı");
        }

        return books;
    }


    /* Kitabın isbn numarasına göre kitabın bilgilerine erişmemizi sağlayan metod */

    public BookIdDto findByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn)
                .map(book1 -> new BookIdDto(book1.getId(), book1.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Bu isbn numarasına ait kitap bulunamadı: " + isbn));
    }

    /* İd ile kitabın detaylarına erişmemizi sağlayan metod */

    public BookDto findBookDetailsById(String id) {
        return bookRepository.findById(id)
                .map(BookDto::convertToBookDto)
                .orElseThrow(() -> new BookNotFoundException("Bu id numarasına sahip kitap bulunamadı: " + id));
    }


    /* veritabanına kitap eklemek için */

    public BookDto addBook(BookDto bookDto, BookIdDto bookIdDto) {

        // ISBN ile kitap var mı diye kontrol
        Optional<Book> existingBook = bookRepository.findBookByIsbn(bookIdDto.getIsbn());

        if (existingBook.isPresent()) {
            throw new TheBookAlreadyExistException("Bu ISBN numarasına sahip kitap zaten veritabanında bulunmakta.");
        }

        Book newBook = new Book(
                null,
                bookDto.getBookYear(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPressName(),
                bookIdDto.getIsbn()
        );

        Book savedBook = bookRepository.save(newBook);
        return BookDto.convertToBookDto(savedBook);
    }


    /*veritabanından kitap silmek için*/

    public void deleteBook(String isbn) {
        Optional<Book> existingBook = bookRepository.findBookByIsbn(isbn);
        if (existingBook.isPresent()) {
            bookRepository.delete(existingBook.get());
        }else {
           throw new BookNotFoundException("Bu isbn numarasına ait kitap bulunamadı:" + isbn);
        }
    }


}
