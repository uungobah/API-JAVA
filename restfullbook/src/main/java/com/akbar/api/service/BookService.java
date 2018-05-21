package com.akbar.api.service;

import com.akbar.api.model.Book;

import java.io.Serializable;
import java.util.List;

public interface BookService {

    Book get(Serializable var1);

    List<Book> getAll();

    void save(Book var1);

    void update(Book var1);

    void delete(Book var1);

}
