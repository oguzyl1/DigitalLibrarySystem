package com.kitaplik.library_service.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryDto {

    private String id;
    private List<BookDto> userBookList ;


    public LibraryDto(String id) {
        this.id = id;
    }

    public LibraryDto() {
    }

    public LibraryDto(String id, List<BookDto> userBookList) {
        this.id = id;
        this.userBookList= Objects.requireNonNullElseGet(userBookList, ArrayList::new);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BookDto> getUserBookList() {
        return userBookList;
    }

    public void setUserBookList(List<BookDto> userBookList) {
        this.userBookList = userBookList;
    }

    @Override
    public String toString() {
        return "LibraryDto{" +
                "id='" + id + '\'' +
                ", userBookList=" + userBookList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryDto that = (LibraryDto) o;
        return Objects.equals(id, that.id) && Objects.equals(userBookList, that.userBookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userBookList);
    }
}
