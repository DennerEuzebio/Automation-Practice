package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPageObjects extends PageObjectsAbstraction {

    protected OrderConfirmationPageObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement getTotalPriceLabel(){
        return byXpath("//*[@id=\"center_column\"]/div/span/strong");
    }

}
