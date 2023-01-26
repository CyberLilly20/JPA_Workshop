package se.lexicon.jpa_workshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_workshop.entity.BookLoan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class BookLoanDaoImpl implements BookLoanDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public BookLoan findById(int id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<BookLoan> findAll() {
        return entityManager.createQuery("select bl from BookLoan bl", BookLoan.class)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookLoan create(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return bookLoan ;
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    public void delete(int bookLoanId) {
        BookLoan bookL = findById(bookLoanId);
        if(bookL != null){
            entityManager.remove(bookL);
        }

    }
}
