package com.kitaplik.library_service.dto;

import java.util.Objects;

public class AddBookRequest {
    private String id;
    private String isbn;

    public AddBookRequest() {
    }

    public AddBookRequest(String id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "AddBookRequest{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddBookRequest that = (AddBookRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn);
    }
}
