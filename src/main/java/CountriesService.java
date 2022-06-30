
import Entity.CountriesEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CountriesService {

    public EntityManager em = Persistence.createEntityManagerFactory("aaa").createEntityManager();

    public CountriesEntity add(CountriesEntity countriesEntity){
        em.getTransaction().begin();
        CountriesEntity countriesFromDB = em.merge(countriesEntity);
        em.getTransaction().commit();
        return countriesFromDB;
    }

    public List<CountriesEntity> getAll(){
        TypedQuery<CountriesEntity> namedQuery= em.createNamedQuery("getAll", CountriesEntity.class);
        return namedQuery.getResultList();
    }

}