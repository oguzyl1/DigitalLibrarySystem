package com.kitaplik.library_service.service;

import com.kitaplik.library_service.client.BookServiceClient;
import com.kitaplik.library_service.dto.AddBookRequest;
import com.kitaplik.library_service.dto.LibraryDto;
import com.kitaplik.library_service.exception.LibraryNotFoundException;
import com.kitaplik.library_service.model.Library;
import com.kitaplik.library_service.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }


    /* oluşturulan kütüphanenin içinteki kitaplara erişebilmek için metod*/

    public LibraryDto getAllBooksInLibraryById(String id) {
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Bu id numarasına sahip kütüphane bulunamadı: " + id));

        return new LibraryDto(
                library.getId(),
                library.getUserBook()
                        .stream()
                        .map(book -> bookServiceClient.getBookById(book).getBody())
                        .collect(Collectors.toList())
        );
    }

    /* Kütüphane oluşturmak için metod */
    public LibraryDto createLibrary() {
        Library library = libraryRepository.save(new Library());
        return new LibraryDto(library.getId());
    }


    /*Kitaplığa kitap eklemek için*/

    public void addBookToLibrary(AddBookRequest addBookRequest) {
        String bookId = bookServiceClient.getBookByIsbn(addBookRequest.getIsbn()).getBody().getBookId();
        Library library = libraryRepository.findById(addBookRequest.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Bu id numarasına sahip kütüphane bulunamadı: " + addBookRequest.getId()));

        library.getUserBook().add(bookId);
        libraryRepository.save(library);
    }


    public List<String> getAllLibraries() {
        return libraryRepository.findAll()
                .stream()
                .map(l -> l.getId())
                .collect(Collectors.toList());
    }
}
