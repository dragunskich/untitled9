package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries", schema = "ddd", catalog = "")
@NamedQuery(name = "getAll", query = "SELECT c from CountriesEntity c ")

public class CountriesEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_country", nullable = false)
    private int idCountry;

    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private List<LanguageEntity> languages;

    @Column(name = "population", nullable = false)
    private int population;


    public List<LanguageEntity> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageEntity> languages) {
        this.languages = languages;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
               "id=" + idCountry +
               ", name='" + name + '\'' +
               ", language=" +  languages +
               ", population=" + population +
                '}';
    }

    public CountriesEntity(int idCountry, String name, List<LanguageEntity> languages, int population) {
        this.idCountry = idCountry;
        this.name = name;
        this.languages = languages;
        this.population = population;
    }
    public CountriesEntity(){

    }


}