package Entity;

import javax.persistence.*;

@Entity
@Table(name = "countries", schema = "ddd", catalog = "")
@NamedQuery(name = "getAll", query = "SELECT c from CountriesEntity c order by name")

public class CountriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCountries", nullable = false)
    private int idCountries;
    @Basic
    @Column(name = "Name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "Language", nullable = true, length = 45)
    private String language;
    @Basic
    @Column(name = "Population", nullable = true)
    private Integer population;

    public int getIdCountries() {
        return idCountries;
    }

    public void setIdCountries(int idCountries) {
        this.idCountries = idCountries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + idCountries +
                ", name='" + name.toUpperCase() + '\'' +
                ", language=" + language +
                ", population=" + population +
                '}';
    }

    public CountriesEntity(String name, String language,int population) {
        this.name = name;
        this.language = language;
        this.population = population;
    }
    public CountriesEntity(){

    }
}