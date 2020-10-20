package support;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakersGenerators {

    private static final Faker faker = new Faker(new Locale("pt-BR"));;

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getPassword() {
        return faker.internet().password(5,10);
    }

    public static String getCompany() {
        return faker.company().name();
    }

    public static String getZipCode() {
        return faker.address().zipCode().substring(0,5);
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getAddressOne() {
        return faker.address().fullAddress();
    }

    public static String getAddressTwo() {
        return faker.address().secondaryAddress();
    }

    public static String getCity() {
        return faker.address().city();
    }

    public static String getNumCellPhone() {
        return faker.phoneNumber().cellPhone();
    }

    public static String getNumPhone() {
        return faker.phoneNumber().phoneNumber();
    }
}