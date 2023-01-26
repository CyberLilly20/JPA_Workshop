package se.lexicon.jpa_workshop.dao;

import se.lexicon.jpa_workshop.entity.Author;

import java.util.Collection;

public interface AuthorDao {

    Author findById(int id);

    Collection<Author> findAll();

    Author create(Author author);

    Author update(Author author);

    void delete(int id);
}
