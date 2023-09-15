package com.mkece.bookstore.controller;


import com.mkece.bookstore.model.Book;
import com.mkece.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
        return bookService.createbook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @GetMapping("/getAll")
    public List<Book> getBooksList() {
       return  bookService.getallBooks();
    }


    @PutMapping("/update")
    public Book updateBook(@RequestBody  Book book){
        return bookService.updateBook(book);
    }


    @DeleteMapping("/{id}")
    public boolean deteBookById(@PathVariable int id){
        return bookService.deleteBook(id);
    }

}