package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentConfirmationPageObjects extends PageObjectsAbstraction {

    public PaymentConfirmationPageObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement getProceedToCheckoutButton(){
        return byXpath("//*[@id=\"cart_navigation\"]/button");
    }


}
