package com.kitaplik.library_service.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Library {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ElementCollection
    private List<String> userBook = new ArrayList<>();

    public Library() {
    }

    public Library(String id, List<String> userBook) {
        this.id = id;
        this.userBook = userBook;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getUserBook() {
        return userBook;
    }

    public void setUserBook(List<String> userBook) {
        this.userBook = userBook;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id='" + id + '\'' +
                ", userBook=" + userBook +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id) && Objects.equals(userBook, library.userBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userBook);
    }
}
