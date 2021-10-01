package com.example.library_management.webrest;

import com.example.library_management.dao.Book;
import com.example.library_management.dto.Bookdto;
import com.example.library_management.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("book")
    public ResponseEntity<Book> creatBook(@RequestBody Bookdto bookdto){
        Book bookRes = bookService.create(bookdto);
        return ResponseEntity.ok().body(bookRes);
    }

    @GetMapping("Allbooks")
    public ResponseEntity<List<Book>>AllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/book/{id}")
    public Optional<Book> retrieveBook(@PathVariable int id){
        return bookService.findBook(id);
    }

    @DeleteMapping("/delBook/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().body("User deleted id : "+ id);
    }

}