package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage extends PageObjectsAbstraction {

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNamesLabel(){
        return byXpath("//*[@id=\"address_delivery\"]/li[2]");
    }

    public WebElement getCompanyLabel(){
        return byXpath("//*[@id=\"address_delivery\"]/li[3]");
    }

    public WebElement getAddressesLabel(){
        return byXpath("//*[@id=\"address_delivery\"]/li[4]");
    }

    public WebElement getPhoneMobileLabel(){
        return byXpath("//*[@id=\"address_delivery\"]/li[8]");
    }

    public WebElement getProceedToCheckoutButton(){
        return byXpath("//*[@id=\"center_column\"]/form/p/button");
    }








}
