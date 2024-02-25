package com.mywork.myspringboot.control;

import com.mywork.myspringboot.dto.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    private static List<Book> data = new ArrayList<Book>();

    static {
        data.add(new Book(1, "Things Fall Apart", "Chinua Achebe"));
        data.add(new Book(2, "Pride and Prejudice", "Austen"));
        data.add(new Book(3, "The Decameron", "Giovanni Boccaccio"));
        data.add(new Book(4, "Molloy, Malone Dies, The Unnamable, the trilogy", "Samuel Beckett"));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok().body(data);
    }
}
