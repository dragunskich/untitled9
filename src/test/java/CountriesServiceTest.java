import Entity.CountriesEntity;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class CountriesServiceTest {
    CountriesService service = new CountriesService();

    @Test
    public void testSaveRecord(){

        CountriesEntity country = new CountriesEntity();
        country.setName("asdfg");
        country.setLanguage("Vcdsdrre");
        country.setPopulation(14324);
        CountriesEntity countriesEntity = service.add(country);

    }
    @Test
    public void testGetAll(){
        
        List<CountriesEntity> countries = service.getAll();

        for(CountriesEntity c : countries){
            System.out.println(c);
        }
    }
}

