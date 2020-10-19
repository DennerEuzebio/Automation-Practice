package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageObjectsAbstraction {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProduct(int itemIndex){
        return byXpath("//*[@id=\"homefeatured\"]/li["+itemIndex+"]/div/div[2]/h5/a");
    }




}
