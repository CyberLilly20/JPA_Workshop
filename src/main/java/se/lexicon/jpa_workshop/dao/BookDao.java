package se.lexicon.jpa_workshop.dao;

import se.lexicon.jpa_workshop.entity.Book;

import java.util.Collection;
import java.util.Optional;

public interface BookDao  {

    Book findById(int id);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void delete(int bookId);



}
