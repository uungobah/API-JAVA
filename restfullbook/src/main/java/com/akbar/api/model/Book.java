package com.akbar.api.model;

import javax.persistence.*;

@Entity
@Table(
        name = "book"
)
public class Book {

    @Id
    @Column(name = "id",
    length = 40)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title",
            length = 100)
    private String title;

    @Column(name = "author",
            length = 100)
    private String author;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
