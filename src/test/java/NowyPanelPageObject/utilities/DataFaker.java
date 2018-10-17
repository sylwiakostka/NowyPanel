package NowyPanelPageObject.utilities;

import com.github.javafaker.Faker;

public class DataFaker {

    private Faker faker;

    public DataFaker (){
        faker = new Faker();
    }

    public String getFakeName(){
        return faker.name().fullName();
    }
}
