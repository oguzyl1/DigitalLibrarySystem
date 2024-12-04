package com.kitaplik.book_service.dto;

import java.util.Objects;

public class BookIdDto {

    private String bookId;
    private String isbn;

    public static BookIdDto convertToBookIdDto(String id, String isbn){
        return new BookIdDto(id,isbn);
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookIdDto(String bookId, String isbn) {
        this.bookId = bookId;
        this.isbn = isbn;
    }

    public BookIdDto() {
    }

    @Override
    public String toString() {
        return "BookIdDto{" +
                "bookId='" + bookId + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookIdDto bookIdDto = (BookIdDto) o;
        return Objects.equals(bookId, bookIdDto.bookId) && Objects.equals(isbn, bookIdDto.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn);
    }
}
