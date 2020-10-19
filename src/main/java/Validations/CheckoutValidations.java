package Validations;

import PageObjects.AddressPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.FileOperations;
import utils.Messages;

public class CheckoutValidations extends ValidationsAbstraction {

    private final AddressPage ADDRESS_PAGE;

    public CheckoutValidations(WebDriver driver) {
        super(driver);
        ADDRESS_PAGE = new AddressPage(this.driver);
    }

    public void validateNames() {
        String firstName = FileOperations.getProperties("UserData").getProperty("firstName");
        String lastName = FileOperations.getProperties("UserData").getProperty("lastName");
        String expected = firstName + " " + lastName;
        String actual = ADDRESS_PAGE.getNamesLabel().getAttribute("innerText");
        tryCatch(expected,actual,Messages.namesCheckoutConfirmationTextboxPass(),
                Messages.namesCheckoutConfirmationTextboxFail(expected, actual),
                ADDRESS_PAGE.getNamesLabel());

    }

    public void validateNamesSHOULDFAIL() {
        String firstName = FileOperations.getProperties("UserData").getProperty("firstName");
        String lastName = FileOperations.getProperties("UserData").getProperty("lastName");
        String expected = firstName + " " + lastName+" LINHA PARA FALHA";
        String actual = ADDRESS_PAGE.getNamesLabel().getAttribute("innerText");
        tryCatch(expected,actual,Messages.namesCheckoutConfirmationTextboxPass(),
                Messages.namesCheckoutConfirmationTextboxFail(expected, actual),
                ADDRESS_PAGE.getNamesLabel());

    }

    public void validateAddresses() {
        String addressOne = FileOperations.getProperties("UserData").getProperty("address1");
        String addressTwo = FileOperations.getProperties("UserData").getProperty("address2");
        String expected = addressOne + " " + addressTwo;
        String actual = ADDRESS_PAGE.getAddressesLabel().getAttribute("innerText");
        tryCatch(expected,actual,Messages.adressCheckoutConfirmationTextboxPass(),
                Messages.adressCheckoutConfirmationTextboxFail(expected, actual),
                ADDRESS_PAGE.getAddressesLabel());
    }

    public void validateCompany() {
        String expected = FileOperations.getProperties("UserData").getProperty("company");
        String actual = ADDRESS_PAGE.getCompanyLabel().getAttribute("innerText");
        tryCatch(expected,actual,Messages.companyCheckoutConfirmationTextboxPass(),
                Messages.companyCheckoutConfirmationTextboxFail(expected, actual),
                ADDRESS_PAGE.getCompanyLabel());
    }

    public void validatePhoneMobile() {
        String expected = FileOperations.getProperties("UserData").getProperty("phoneMobile");
        String actual = ADDRESS_PAGE.getPhoneMobileLabel().getAttribute("innerText");
        tryCatch(expected,actual,Messages.phoneCheckoutConfirmationTextboxPass(),
                Messages.phoneCheckoutConfirmationTextboxFail(expected, actual),
                ADDRESS_PAGE.getPhoneMobileLabel());
    }
}
