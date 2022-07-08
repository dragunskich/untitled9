package Repository;

import Entity.CountriesEntity;
import Entity.LanguageEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryRepository {
    public EntityManager em = Persistence.createEntityManagerFactory("aaa").createEntityManager();

    public List<CountriesEntity> getAll() {
        TypedQuery<CountriesEntity> namedQuery = em.createNamedQuery("getAll", CountriesEntity.class);
        return namedQuery.getResultList();
    }

    public List<CountriesEntity> getCountriesToAddLanguage(String NameAddLanguage) {
        List<CountriesEntity> countriesEntities = em.createQuery("SELECT c from CountriesEntity c where c.name=?1")
                .setParameter(1, NameAddLanguage)
                .getResultList();
        return countriesEntities;
    }


    public CountriesEntity add(CountriesEntity countriesEntity) {
        em.getTransaction().begin();
        CountriesEntity countriesFromDB = em.merge(countriesEntity);
        em.getTransaction().commit();
        return countriesFromDB;
    }

    public LanguageEntity addLanguage(LanguageEntity languageEntity) {
        em.getTransaction().begin();
        em.getTransaction().commit();
        return languageEntity;
    }
}
