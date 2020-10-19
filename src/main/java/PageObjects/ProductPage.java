package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends PageObjectsAbstraction {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton(){
        return byId("add_to_cart");
    }

    public WebElement getProductPrice(){
        return byId("our_price_display");
    }

    public WebElement getSku(){
        return byXpath("//*[@id=\"product_reference\"]/span");
    }

    public WebElement getProductName(){
        return byXpath("//*[@id=\"center_column\"]/div/div/div[3]/h1");
    }

    public WebElement getProductQuantity(){
        return byId("quantity_wanted");
    }
}
