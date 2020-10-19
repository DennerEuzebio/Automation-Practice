package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPageObjects extends PageObjectsAbstraction {

    public ShippingPageObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement getPriceLabel(){
        return byXpath("//*[@id=\"form\"]/div/div[2]/div[1]/div/div/table/tbody/tr/td[4]/div");
    }

    public WebElement getTermsCheckBox(){
        return byId("cgv");
    }

    public WebElement getProceedToCheckoutButton(){
        return byXpath("//*[@id=\"form\"]/p/button");
    }
}
