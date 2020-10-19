package Tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.FakersGenerators;
import support.FileOperations;

import java.io.IOException;
import java.util.Random;

public class AuthenticationTasks extends TasksAbstraction {
    private Random random = new Random();

    public AuthenticationTasks(WebDriver driver) {
        super(driver);
    }

    public void login(){
        homePage.getSinginButton().click();
        sendKeys(authenticationPage.getEmailTextBox(),"email");
        sendKeys(authenticationPage.getPasswordTextBox(),"password");
        authenticationPage.getSignInButton().click();
    }

    public void createNewUser() throws IOException {
        generateRandomUserData();

        sendKeys(authenticationPage.getEmailCreateTextBox(),"email");
        authenticationPage.getSubmitCreateButton().click();
        fillCreateUserForm();
    }

    private void fillCreateUserForm(){
        sendKeys(createUserFormPage.getFirstNameTextBox(), "firstName");
        sendKeys(createUserFormPage.getLastNameTextBox(),"lastName");
        createUserFormValidation.validateEmailTextBoxValue();
        sendKeys(createUserFormPage.getPasswordTextBox(),"password");
        createUserFormPage.getDaysSelect().selectByIndex(random.nextInt(30)+1);
        createUserFormPage.getMonthsSelect().selectByIndex(random.nextInt(11)+1);
        createUserFormPage.getYearsSelect().selectByIndex(random.nextInt(100)+1);
        createUserFormValidation.validateFirstNameTextBoxValue();
        createUserFormValidation.validateLastNameTextBoxValue();
        sendKeys(createUserFormPage.getCompanyTextBox(),"company");
        sendKeys(createUserFormPage.getAddressOneTextBox(),"address1");
        sendKeys(createUserFormPage.getAddressTwoTextBox(),"address2");
        sendKeys(createUserFormPage.getCityTextBox(),"city");
        createUserFormPage.getStateSelect().selectByIndex(random.nextInt(49)+1);
        sendKeys(createUserFormPage.getZipCodeTextBox(),"zipCode");
        sendKeys(createUserFormPage.getPhoneTextBox(),"phone");
        sendKeys(createUserFormPage.getPhoneMobileTextBox(),"phoneMobile");
        createUserFormPage.getRegisterButton().click();
    }

    private void generateRandomUserData() throws IOException {
        FileOperations.setProperties("UserData","email",FakersGenerators.getEmail());
        FileOperations.setProperties("UserData", "firstName",FakersGenerators.getFirstName());
        FileOperations.setProperties("UserData","lastName",FakersGenerators.getLastName());
        FileOperations.setProperties("UserData","password",FakersGenerators.getPassword());
        FileOperations.setProperties("UserData","company",FakersGenerators.getCompany());
        FileOperations.setProperties("UserData","address1",FakersGenerators.getAddressOne());
        FileOperations.setProperties("UserData","address2",FakersGenerators.getAddressTwo());
        FileOperations.setProperties("UserData","city",FakersGenerators.getCity());
        FileOperations.setProperties("UserData","zipCode",FakersGenerators.getZipCode());
        FileOperations.setProperties("UserData","phone",FakersGenerators.getNumPhone());
        FileOperations.setProperties("UserData","phoneMobile",FakersGenerators.getNumCellPhone());
    }

    public void sendKeys(WebElement webElement,String propertyKey){
        webElement.sendKeys(FileOperations.getProperties("UserData").getProperty(propertyKey));
    }


}