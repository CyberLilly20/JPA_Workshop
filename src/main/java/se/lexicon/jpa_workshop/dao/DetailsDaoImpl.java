package se.lexicon.jpa_workshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_workshop.entity.Details;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class DetailsDaoImpl implements DetailsDao{
    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public Optional<Details> findById(int id) {
        return Optional.ofNullable(entityManager.find(Details.class, id)) ;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Details> findAll() {
        return entityManager.createQuery("select d from Details d").getResultList();
    }

    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return details;

    }

    @Override
    @Transactional
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Details.class, id));

    }
}
