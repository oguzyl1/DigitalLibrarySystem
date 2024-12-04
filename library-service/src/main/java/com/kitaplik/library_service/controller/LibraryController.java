package com.kitaplik.library_service.controller;

import com.kitaplik.library_service.dto.AddBookRequest;
import com.kitaplik.library_service.dto.LibraryDto;
import com.kitaplik.library_service.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id){
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary(){
        return ResponseEntity.ok(libraryService.createLibrary());
    }


    @PutMapping
    public ResponseEntity<Void> addBookToLibrary (@RequestBody AddBookRequest request){
        libraryService.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }

}
