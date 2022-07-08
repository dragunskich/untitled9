package Repository;

import Entity.CountriesEntity;
import Entity.LanguageEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("aaa");

    public List<CountriesEntity> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            List<CountriesEntity> namedQuery = em.createNamedQuery("getAll", CountriesEntity.class).getResultList();
            return namedQuery;
        } finally {
            em.close();
        }
    }

    public List<CountriesEntity> getCountriesByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            List<CountriesEntity> countriesEntities = em.createQuery("SELECT c from CountriesEntity c where c.name=?1")
                    .setParameter(1, name)
                    .getResultList();
            return countriesEntities;
        } finally {
            em.close();
        }

    }


    public CountriesEntity add(CountriesEntity countriesEntity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            CountriesEntity countriesFromDB = em.merge(countriesEntity);
            em.getTransaction().commit();
            return countriesFromDB;
        } finally {
            em.close();
        }
    }

    public LanguageEntity addLanguage(LanguageEntity languageEntity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(languageEntity);
            em.getTransaction().commit();
            return languageEntity;
        } finally {
            em.close();
        }
    }
}
