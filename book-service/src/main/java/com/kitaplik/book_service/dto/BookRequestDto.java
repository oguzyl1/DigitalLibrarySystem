package com.kitaplik.book_service.dto;

import java.util.Objects;

public class BookRequestDto {

    private BookDto bookDto;
    private BookIdDto bookIdDto;



    public BookRequestDto(){
    }

    public BookRequestDto(BookDto bookDto, BookIdDto bookIdDto) {
        this.bookDto = bookDto;
        this.bookIdDto = bookIdDto;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public BookIdDto getBookIdDto() {
        return bookIdDto;
    }

    public void setBookIdDto(BookIdDto bookIdDto) {
        this.bookIdDto = bookIdDto;
    }

    @Override
    public String toString() {
        return "BookRequestDto{" +
                "bookDto=" + bookDto +
                ", bookIdDto=" + bookIdDto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRequestDto that = (BookRequestDto) o;
        return Objects.equals(bookDto, that.bookDto) && Objects.equals(bookIdDto, that.bookIdDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookDto, bookIdDto);
    }
}
