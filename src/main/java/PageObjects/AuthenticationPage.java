package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage extends PageObjectsAbstraction {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailCreateTextBox(){
        return byId("email_create");
    }

    public WebElement getSubmitCreateButton(){
        return byId("SubmitCreate");
    }

    public WebElement getEmailTextBox(){
        return byId("email");
    }

    public WebElement getPasswordTextBox(){
        return byId("passwd");
    }

    public WebElement getSignInButton(){
        return byId("SubmitLogin");
    }


}
