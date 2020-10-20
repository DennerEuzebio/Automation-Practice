package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPageObjects extends PageObjectsAbstraction {

    public ShippingPageObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement getTermsCheckBox(){
        return byId("cgv");
    }

    public WebElement getProceedToCheckoutButton(){
        return byXpath("//*[@id=\"form\"]/p/button");
    }
}
