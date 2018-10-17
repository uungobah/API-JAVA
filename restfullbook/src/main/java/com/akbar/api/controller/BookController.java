package com.akbar.api.controller;

import com.akbar.api.model.Book;
import com.akbar.api.service.BookService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
        JsonObject object = new JsonObject();
        object.addProperty("status","Sukses");
        JsonArray jsonArray = new JsonArray();
        JsonObject object1 = new JsonObject();
        object1.addProperty("Author","Äkbar");
        object1.addProperty("Title","Fisika");
        jsonArray.add(object1);
        jsonArray.add(object1);
        object.add("array",jsonArray);
        return ResponseEntity.ok().body(object.toString());
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
