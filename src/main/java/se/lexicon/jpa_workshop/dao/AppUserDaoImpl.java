package se.lexicon.jpa_workshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_workshop.entity.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class AppUserDaoImpl implements AppUserDao {
    @PersistenceContext
    EntityManager entityManager;



    @Override
    @Transactional(readOnly = true)
    public Optional<AppUser> findById(int id) {
        return Optional.ofNullable(entityManager.find(AppUser.class, id));

    }

    @Override
    @Transactional(readOnly = true)
    public Collection<AppUser> findAll() {
        return entityManager.
                createQuery("select a from AppUser a", AppUser.class)
                .getResultList();

    }

    @Override
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        AppUser appUser = entityManager.find(AppUser.class,id);
       if(appUser!= null) entityManager.remove(id);




    }
}
