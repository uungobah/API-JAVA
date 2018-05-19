package com.akbar.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "book"
)
public class Book {

    @Id
    @Column(name = "id",
    length = 40)
    private String id;

    @Column(name = "title",
            length = 100)
    private String title;

    @Column(name = "author",
            length = 100)
    private String author;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
