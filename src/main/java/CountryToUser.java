import Entity.LanguageEntity;

import java.util.List;

public class CountryToUser {

    private String name;
    private List<LanguageEntity> languages;
    private int population;

    public CountryToUser(String name, List<LanguageEntity> languages, int population)
    {
        this.name = name;
        this.languages = languages;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LanguageEntity> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageEntity> languages) {
        this.languages = languages;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", language=" +  languages +
                ", population=" + population +
                '}';
    }
}
