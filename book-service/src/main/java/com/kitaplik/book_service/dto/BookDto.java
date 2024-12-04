package com.kitaplik.book_service.dto;

import com.kitaplik.book_service.model.Book;

import java.util.Objects;

public class BookDto {

    private BookIdDto bookId = new BookIdDto();
    private String title;
    private int bookYear;
    private String author;
    private String pressName;

    public static BookDto convertToBookDto(Book book) {
        return new BookDto(
                book.getId() != null ? BookIdDto.convertToBookIdDto(book.getId(),book.getIsbn()) : null,
                book.getTitle(),
                book.getBookYear(),
                book.getAuthor(),
                book.getPressName()
        );
    }


    public BookDto() {
    }

    public BookDto(BookIdDto bookId, String title, int bookYear, String author, String pressName) {
        this.bookId = bookId;
        this.title = title;
        this.bookYear = bookYear;
        this.author = author;
        this.pressName = pressName;
    }

    public BookIdDto getBookId() {
        return bookId;
    }

    public void setBookId(BookIdDto bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", bookYear=" + bookYear +
                ", author='" + author + '\'' +
                ", pressName='" + pressName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(bookId, bookDto.bookId) && Objects.equals(title, bookDto.title) && Objects.equals(bookYear, bookDto.bookYear) && Objects.equals(author, bookDto.author) && Objects.equals(pressName, bookDto.pressName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, bookYear, author, pressName);
    }
}
