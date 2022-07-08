import Entity.CountriesEntity;

import java.util.ArrayList;
import java.util.List;

import Entity.LanguageEntity;
import org.junit.Test;

public class CountriesServiceTest {
   CountriesService service = new CountriesService();

    @Test
    public void testSaveRecord(){

        CountriesEntity country = new CountriesEntity();
        country.setName("zxc");
        country.setPopulation(153);

        CountriesEntity countriesEntity = service.add(country);

    }
    @Test
    public void testGetAll(){
        List<CountryToUser> countries = service.getAll(0);
        for(CountryToUser c : countries){
                System.out.println(c);
        }

    }
    @Test
    public void testAddLanguage(){
        service.addLanguageToCountryName("Cdshile","French");

    }
}

