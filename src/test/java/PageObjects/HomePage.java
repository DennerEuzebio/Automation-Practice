package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObjectsAbstraction {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProduct(int itemIndex){
        return byXpath("//*[@id='homefeatured']/li["+itemIndex+"]/div/div[2]/h5/a");
    }

//    public WebElement getHomeLogo(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_logo")));
//        return byId("header_logo");
//    }

    public WebElement getHomeLogo(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_logo")));
        return byXpath("//*[@id=\"header_logo\"]/a/img");
    }



    public WebElement getSinginButton(){
        return byXpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]");
    }

    public WebElement getCartCollapse(){
        return byXpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
    }






}
