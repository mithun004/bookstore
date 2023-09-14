package com.mkece.bookstore.service;

import com.mkece.bookstore.model.Book;

import java.util.List;

public interface BookService {


    // create book
    public Book createbook( Book book);

    // get book by id

    public Book getBook(int id);


    // get all boooks
    public List<Book> getallBooks();

    // update book
    Book updateBook(Book book);

    boolean deleteBook(int id);

}
