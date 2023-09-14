package com.mkece.bookstore.service;

import com.mkece.bookstore.model.Book;
import com.mkece.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book createbook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.findById(id).get();
    }



    @Override
    public List<Book> getallBooks() {
        return bookRepository.findAll();
    }


    @Override
    public Book updateBook(Book updateBook) {
        Optional<Book> existingBook = bookRepository.findById(updateBook.getId());

        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(updateBook.getTitle());
            book.setAuthor(updateBook.getAuthor());
            book.setDescription(updateBook.getDescription());
            book.setPrice(updateBook.getPrice());
            book.setPublisher(updateBook.getPublisher());
            bookRepository.save(book);
        } else {
            // Handle the case when the book does not exist
            // You can throw an exception or handle it in any other appropriate way
            throw new RuntimeException(("Book not found: " + updateBook.getId()));
        }

        return updateBook;
    }




    @Override
    public boolean deleteBook(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
