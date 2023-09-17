package com.mkece.bookstore.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkece.bookstore.model.Book;
import com.mkece.bookstore.service.BookService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BookController.class})
@ExtendWith(SpringExtension.class)
class BookControllerTest {
    @Autowired
    private BookController bookController;

    @MockBean
    private BookService bookService;

    /**
     * Method under test: {@link BookController#createBook(Book)}
     */
    @Test
    void testCreateBook() throws Exception {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setId(1);
        book.setPages(1);
        book.setPrice(10.0d);
        book.setPublisher("Publisher");
        book.setTitle("Dr");
        when(bookService.createbook(Mockito.<Book>any())).thenReturn(book);

        Book book2 = new Book();
        book2.setAuthor("JaneDoe");
        book2.setDescription("The characteristics of someone or something");
        book2.setId(1);
        book2.setPages(1);
        book2.setPrice(10.0d);
        book2.setPublisher("Publisher");
        book2.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(book2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/book/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"author\":\"JaneDoe\",\"title\":\"Dr\",\"description\":\"The characteristics of someone or something\","
                                        + "\"publisher\":\"Publisher\",\"price\":10.0,\"pages\":1}"));
    }

    /**
     * Method under test: {@link BookController#updateBook(Book)}
     */
    @Test
    void testUpdateBook() throws Exception {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setId(1);
        book.setPages(1);
        book.setPrice(10.0d);
        book.setPublisher("Publisher");
        book.setTitle("Dr");
        when(bookService.updateBook(Mockito.<Book>any())).thenReturn(book);

        Book book2 = new Book();
        book2.setAuthor("JaneDoe");
        book2.setDescription("The characteristics of someone or something");
        book2.setId(1);
        book2.setPages(1);
        book2.setPrice(10.0d);
        book2.setPublisher("Publisher");
        book2.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(book2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/book/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"author\":\"JaneDoe\",\"title\":\"Dr\",\"description\":\"The characteristics of someone or something\","
                                        + "\"publisher\":\"Publisher\",\"price\":10.0,\"pages\":1}"));
    }

    /**
     * Method under test: {@link BookController#deteBookById(int)}
     */
    @Test
    void testDeteBookById() throws Exception {
        when(bookService.deleteBook(anyInt())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/book/{id}", 1);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BookController#deteBookById(int)}
     */
    @Test
    void testDeteBookById2() throws Exception {
        when(bookService.deleteBook(anyInt())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/book/{id}", 1);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link BookController#getBookById(int)}
     */
    @Test
    void testGetBookById() throws Exception {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setId(1);
        book.setPages(1);
        book.setPrice(10.0d);
        book.setPublisher("Publisher");
        book.setTitle("Dr");
        when(bookService.getBook(anyInt())).thenReturn(book);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/{id}", 1);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"author\":\"JaneDoe\",\"title\":\"Dr\",\"description\":\"The characteristics of someone or something\","
                                        + "\"publisher\":\"Publisher\",\"price\":10.0,\"pages\":1}"));
    }

    /**
     * Method under test: {@link BookController#getBooksList()}
     */
    @Test
    void testGetBooksList() throws Exception {
        when(bookService.getallBooks()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/getAll");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

