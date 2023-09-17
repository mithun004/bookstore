package com.mkece.bookstore.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BookTest {

/**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Book#Book()}
     *   <li>{@link Book#setAuthor(String)}
     *   <li>{@link Book#setDescription(String)}
     *   <li>{@link Book#setId(int)}
     *   <li>{@link Book#setPages(int)}
     *   <li>{@link Book#setPrice(double)}
     *   <li>{@link Book#setPublisher(String)}
     *   <li>{@link Book#setTitle(String)}
     *   <li>{@link Book#getAuthor()}
     *   <li>{@link Book#getDescription()}
     *   <li>{@link Book#getId()}
     *   <li>{@link Book#getPages()}
     *   <li>{@link Book#getPrice()}
     *   <li>{@link Book#getPublisher()}
     *   <li>{@link Book#getTitle()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Book actualBook = new Book();
        actualBook.setAuthor("JaneDoe");
        actualBook.setDescription("The characteristics of someone or something");
        actualBook.setId(1);
        actualBook.setPages(1);
        actualBook.setPrice(10.0d);
        actualBook.setPublisher("Publisher");
        actualBook.setTitle("Dr");
        String actualAuthor = actualBook.getAuthor();
        String actualDescription = actualBook.getDescription();
        int actualId = actualBook.getId();
        int actualPages = actualBook.getPages();
        double actualPrice = actualBook.getPrice();
        String actualPublisher = actualBook.getPublisher();
        assertEquals("JaneDoe", actualAuthor);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(1, actualId);
        assertEquals(1, actualPages);
        assertEquals(10.0d, actualPrice);
        assertEquals("Publisher", actualPublisher);
        assertEquals("Dr", actualBook.getTitle());
    }

    /**
     * Method under test: {@link Book#Book(int, String, String, String, String, double, int)}
     */
    @Test
    void testConstructor2() {
        Book actualBook = new Book(1, "JaneDoe", "Dr", "The characteristics of someone or something", "Publisher", 10.0d,
                1);

        assertEquals("JaneDoe", actualBook.getAuthor());
        assertEquals("Dr", actualBook.getTitle());
        assertEquals("Publisher", actualBook.getPublisher());
        assertEquals(10.0d, actualBook.getPrice());
        assertEquals(1, actualBook.getPages());
        assertEquals(1, actualBook.getId());
        assertEquals("The characteristics of someone or something", actualBook.getDescription());
    }
}

