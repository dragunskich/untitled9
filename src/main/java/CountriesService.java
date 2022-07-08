
import Entity.CountriesEntity;
import Entity.LanguageEntity;
import Repository.CountryRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CountriesService {

    private CountryRepository countryRepository = new CountryRepository();

    public CountriesEntity add(CountriesEntity countriesEntity) {
        return countryRepository.add(countriesEntity);
    }


    public List<CountryToUser> getAll(long minPopulation) {
        var countries = countryRepository.getAll();
        List<CountryToUser> countryList = new ArrayList<>();
        countries.sort(new Comparator<CountriesEntity>() {
            @Override
            public int compare(CountriesEntity o1, CountriesEntity o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (CountriesEntity country : countries) {
            if (country.getPopulation() > minPopulation) {
                CountryToUser countrytoUser = new CountryToUser(country.getName().toUpperCase(), country.getLanguages(), country.getPopulation());
                countryList.add(countrytoUser);
            }
        }
        return countryList;
    }

    public LanguageEntity addLanguageToCountryName(String name, String language) {
        var countries = countryRepository.getCountriesByName(name);
        System.out.println(countries);
        if (countries.isEmpty()) {
            throw new CountryNotFoundException();
        }
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setLanguage(language);
        for (CountriesEntity country : countries) {
            languageEntity.setCountry(country);
            country.getLanguages().add(languageEntity);
            System.out.println(country);
        }
        return countryRepository.addLanguage(languageEntity);
    }
}