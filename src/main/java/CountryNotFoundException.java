
public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException() {
        super ("Не удается найти страну для добавления");
    }
    public CountryNotFoundException(String message) {
        super(message);
    }

}