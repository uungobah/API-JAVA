package com.akbar.api.controller;

import com.akbar.api.model.Book;
import com.akbar.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class BookController {

    Logger log = Logger.getLogger(BookController.class.getName());

    @Autowired
    private BookService bookService;

    /*---Add new book---*/
    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book, HttpServletRequest request) {
        bookService.save(book);
        request.getSession();
        log.info("HEADER -->" + request.getHeader("Content-Type"));
        return ResponseEntity.ok().body("New Book has been saved");
    }

    /*---Get a book by id---*/
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") String id) {
        Book result = bookService.get(id);
        return ResponseEntity.ok().body(result);
    }

    /*---get all books---*/
    @GetMapping("/book")
    public ResponseEntity<List<Book>> list() {
        List<Book> books = bookService.getAll();
        return ResponseEntity.ok().body(books);
    }

    /*---Update a book by id---*/
    @PutMapping("/book")
    public ResponseEntity<?> update(@RequestBody Book book) {
        bookService.update(book);
        return ResponseEntity.ok().body("Book has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/book")
    public ResponseEntity<?> delete(@RequestBody Book book) {
        bookService.delete(book);
        return ResponseEntity.ok().body("Book has been deleted successfully.");
    }
}
