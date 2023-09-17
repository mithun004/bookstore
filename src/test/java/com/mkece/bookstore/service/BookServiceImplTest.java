package com.mkece.bookstore.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mkece.bookstore.model.Book;
import com.mkece.bookstore.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BookServiceImplTest {
    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookServiceImpl bookServiceImpl;

    /**
     * Method under test: {@link BookServiceImpl#createbook(Book)}
     */
    @Test
    void testCreatebook() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setId(1);
        book.setPages(1);
        book.setPrice(10.0d);
        book.setPublisher("Publisher");
        book.setTitle("Dr");
        when(bookRepository.save(Mockito.<Book>any())).thenReturn(book);

        Book book2 = new Book();
        book2.setAuthor("JaneDoe");
        book2.setDescription("The characteristics of someone or something");
        book2.setId(1);
        book2.setPages(1);
        book2.setPrice(10.0d);
        book2.setPublisher("Publisher");
        book2.setTitle("Dr");
        assertSame(book, bookServiceImpl.createbook(book2));
        verify(bookRepository).save(Mockito.<Book>any());
    }

    /**
     * Method under test: {@link BookServiceImpl#createbook(Book)}
     */
    @Test
    void testCreatebook2() {
        when(bookRepository.save(Mockito.<Book>any())).thenThrow(new RuntimeException("foo"));

        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setId(1);
        book.setPages(1);
        book.setPrice(10.0d);
        book.setPublisher("Publisher");
        book.setTitle("Dr");
        assertThrows(RuntimeException.class, () -> bookServiceImpl.createbook(book));
        verify(bookRepository).save(Mockito.<Book>any());
    }

    /**
     * Method under test: {@link BookServiceImpl#getBook(int)}
     */
    @Test
    void testGetBook() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setId(1);
        book.setPages(1);
        book.setPrice(10.0d);
        book.setPublisher("Publisher");
        book.setTitle("Dr");
        Optional<Book> ofResult = Optional.of(book);
        when(bookRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        assertSame(book, bookServiceImpl.getBook(1));
        verify(bookRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link BookServiceImpl#getBook(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetBook2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.mkece.bookstore.service.BookServiceImpl.getBook(BookServiceImpl.java:24)
        //   See https://diff.blue/R013 to resolve this issue.

        Optional<Book> emptyResult = Optional.empty();
        when(bookRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        bookServiceImpl.getBook(1);
    }

    /**
     * Method under test: {@link BookServiceImpl#getBook(int)}
     */
    @Test
    void testGetBook3() {
        when(bookRepository.findById(Mockito.<Integer>any())).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> bookServiceImpl.getBook(1));
        verify(bookRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link BookServiceImpl#getallBooks()}
     */
    @Test
    void testGetallBooks() {
        ArrayList<Book> bookList = new ArrayList<>();
        when(bookRepository.findAll()).thenReturn(bookList);
        List<Book> actualGetallBooksResult = bookServiceImpl.getallBooks();
        assertSame(bookList, actualGetallBooksResult);
        assertTrue(actualGetallBooksResult.isEmpty());
        verify(bookRepository).findAll();
    }

    /**
     * Method under test: {@link BookServiceImpl#getallBooks()}
     */
    @Test
    void testGetallBooks2() {
        when(bookRepository.findAll()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> bookServiceImpl.getallBooks());
        verify(bookRepository).findAll();
    }

    /**
     * Method under test: {@link BookServiceImpl#updateBook(Book)}
     */
    @Test
    void testUpdateBook() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setId(1);
        book.setPages(1);
        book.setPrice(10.0d);
        book.setPublisher("Publisher");
        book.setTitle("Dr");
        Optional<Book> ofResult = Optional.of(book);

        Book book2 = new Book();
        book2.setAuthor("JaneDoe");
        book2.setDescription("The characteristics of someone or something");
        book2.setId(1);
        book2.setPages(1);
        book2.setPrice(10.0d);
        book2.setPublisher("Publisher");
        book2.setTitle("Dr");
        when(bookRepository.save(Mockito.<Book>any())).thenReturn(book2);
        when(bookRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Book updateBook = new Book();
        updateBook.setAuthor("JaneDoe");
        updateBook.setDescription("The characteristics of someone or something");
        updateBook.setId(1);
        updateBook.setPages(1);
        updateBook.setPrice(10.0d);
        updateBook.setPublisher("Publisher");
        updateBook.setTitle("Dr");
        assertSame(updateBook, bookServiceImpl.updateBook(updateBook));
        verify(bookRepository).save(Mockito.<Book>any());
        verify(bookRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link BookServiceImpl#updateBook(Book)}
     */
    @Test
    void testUpdateBook2() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setId(1);
        book.setPages(1);
        book.setPrice(10.0d);
        book.setPublisher("Publisher");
        book.setTitle("Dr");
        Optional<Book> ofResult = Optional.of(book);
        when(bookRepository.save(Mockito.<Book>any())).thenThrow(new RuntimeException("foo"));
        when(bookRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Book updateBook = new Book();
        updateBook.setAuthor("JaneDoe");
        updateBook.setDescription("The characteristics of someone or something");
        updateBook.setId(1);
        updateBook.setPages(1);
        updateBook.setPrice(10.0d);
        updateBook.setPublisher("Publisher");
        updateBook.setTitle("Dr");
        assertThrows(RuntimeException.class, () -> bookServiceImpl.updateBook(updateBook));
        verify(bookRepository).save(Mockito.<Book>any());
        verify(bookRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link BookServiceImpl#updateBook(Book)}
     */
    @Test
    void testUpdateBook3() {
        Optional<Book> emptyResult = Optional.empty();
        when(bookRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        Book updateBook = new Book();
        updateBook.setAuthor("JaneDoe");
        updateBook.setDescription("The characteristics of someone or something");
        updateBook.setId(1);
        updateBook.setPages(1);
        updateBook.setPrice(10.0d);
        updateBook.setPublisher("Publisher");
        updateBook.setTitle("Dr");
        assertThrows(RuntimeException.class, () -> bookServiceImpl.updateBook(updateBook));
        verify(bookRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link BookServiceImpl#deleteBook(int)}
     */
    @Test
    void testDeleteBook() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setId(1);
        book.setPages(1);
        book.setPrice(10.0d);
        book.setPublisher("Publisher");
        book.setTitle("Dr");
        Optional<Book> ofResult = Optional.of(book);
        doNothing().when(bookRepository).deleteById(Mockito.<Integer>any());
        when(bookRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        assertTrue(bookServiceImpl.deleteBook(1));
        verify(bookRepository).findById(Mockito.<Integer>any());
        verify(bookRepository).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link BookServiceImpl#deleteBook(int)}
     */
    @Test
    void testDeleteBook2() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setId(1);
        book.setPages(1);
        book.setPrice(10.0d);
        book.setPublisher("Publisher");
        book.setTitle("Dr");
        Optional<Book> ofResult = Optional.of(book);
        doThrow(new RuntimeException("foo")).when(bookRepository).deleteById(Mockito.<Integer>any());
        when(bookRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> bookServiceImpl.deleteBook(1));
        verify(bookRepository).findById(Mockito.<Integer>any());
        verify(bookRepository).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link BookServiceImpl#deleteBook(int)}
     */
    @Test
    void testDeleteBook3() {
        Optional<Book> emptyResult = Optional.empty();
        when(bookRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        assertFalse(bookServiceImpl.deleteBook(1));
        verify(bookRepository).findById(Mockito.<Integer>any());
    }
}

