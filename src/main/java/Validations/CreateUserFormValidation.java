package Validations;

import PageObjects.CreateUserFormPage;
import org.openqa.selenium.WebDriver;
import utils.FileOperations;
import utils.Messages;

public class CreateUserFormValidation extends ValidationsAbstraction {

    private final CreateUserFormPage CREATE_USER_FORM_PAGE;

    public CreateUserFormValidation(WebDriver driver) {
        super(driver);
        CREATE_USER_FORM_PAGE = new CreateUserFormPage(driver);
    }

    public void validateEmailTextBoxValue() {

        String expected = FileOperations.getProperties("UserData").getProperty("email");
        String actual = CREATE_USER_FORM_PAGE.getEmailTextBox().getAttribute("value");
        tryCatch(expected,actual,Messages.emailFormConfirmationTextboxPass(),
                Messages.emailFormConfirmationTextboxFail(expected, actual),
                CREATE_USER_FORM_PAGE.getEmailTextBox());
    }

    public void validateFirstNameTextBoxValue() {
        String expected = FileOperations.getProperties("UserData").getProperty("firstName");
        String actual = CREATE_USER_FORM_PAGE.getFirstNameConfirmationTextBox().getAttribute("value");
        tryCatch(expected,actual,Messages.firstNameFormConfirmationTextboxPass(),
                Messages.firstNameFormConfirmationTextboxFail(expected, actual),
                CREATE_USER_FORM_PAGE.getFirstNameConfirmationTextBox());
    }

    public void validateLastNameTextBoxValue() {
        String expected = FileOperations.getProperties("UserData").getProperty("lastName");
        String actual = CREATE_USER_FORM_PAGE.getLastNameConfirmationTextBox().getAttribute("value");
        tryCatch(expected,actual,Messages.lastNameFormConfirmationTextboxPass(),
                Messages.lastNameFormConfirmationTextboxFail(expected, actual),
                CREATE_USER_FORM_PAGE.getLastNameConfirmationTextBox());
    }


}
