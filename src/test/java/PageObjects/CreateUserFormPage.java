package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateUserFormPage extends PageObjectsAbstraction {

    public CreateUserFormPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstNameTextBox(){
        return byId("customer_firstname");
    }

    public WebElement getLastNameTextBox(){
        return byId("customer_lastname");
    }

    public WebElement getEmailTextBox(){
        return byId("email");
    }

    public WebElement getPasswordTextBox(){
        return byId("passwd");
    }

    public Select getDaysSelect(){
        return selectById("days");
    }

    public Select getMonthsSelect(){
        return selectById("months");
    }

    public Select getYearsSelect(){
        return selectById("years");
    }

    public WebElement getFirstNameConfirmationTextBox(){
        return byId("firstname");
    }

    public WebElement getLastNameConfirmationTextBox(){
        return byId("lastname");
    }

    public WebElement getCompanyTextBox(){
        return byId("company");
    }

    public WebElement getAddressOneTextBox(){
        return byId("address1");
    }

    public WebElement getAddressTwoTextBox(){
        return byId("address2");
    }

    public WebElement getCityTextBox(){
        return byId("city");
    }

    public Select getStateSelect(){
        return selectById("id_state");
    }

    public WebElement getZipCodeTextBox(){
        return byId("postcode");
    }

    public WebElement getPhoneTextBox(){
        return byId("phone");
    }

    public WebElement getPhoneMobileTextBox(){
        return byId("phone_mobile");
    }

    public WebElement getRegisterButton(){
        return byId("submitAccount");
    }


}