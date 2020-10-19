package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModalsPage extends PageObjectsAbstraction {

    public ModalsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProceedToCheckouButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));
        return byXpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    }

    public WebElement getContinueShoppingButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));
        return byXpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span");
    }




    public WebElement getAddToCartButton(){
        return byId("add_to_cart");
    }

}
