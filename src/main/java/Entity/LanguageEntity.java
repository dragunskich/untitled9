package Entity;

import javax.persistence.*;
@Entity
@Table(name = "languages_all", schema = "ddd", catalog = "")
public class LanguageEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_language", nullable = false)
    private int idLanguage;
    @Basic
    @Column(name = "language", nullable = true, length = 45)
    private String language;
    @ManyToOne
    @JoinColumn(name = "country")
    private CountriesEntity country;

    public long getIdLanguage() {
        return idLanguage;
    }

    public void setCountry(CountriesEntity country) {
        this.country = country;
    }

    public void setIdLanguage(int idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public CountriesEntity getCountry() {
        return country;
    }


    public LanguageEntity(int idLanguage, String language, CountriesEntity country) {
        this.idLanguage = idLanguage;
        this.language = language;
        this.country= country;
    }
    public LanguageEntity(){

    }

    public String toString() {
        return language;
    }
}
