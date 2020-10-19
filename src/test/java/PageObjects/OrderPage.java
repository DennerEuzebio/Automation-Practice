package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage extends PageObjectsAbstraction {

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProceedToCheckoutButton(){
        return byXpath("//*[@id=\"center_column\"]/p[2]/a[1]");
    }

    public WebElement getProductUnitPriceLabel(int itemIndex) {
        return byXpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr["+itemIndex+"]/td[4]/span/span");
    }

    public WebElement getProductQuantityInput(int itemIndex) {
        return byXpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr["+itemIndex+"]/td[5]/input[2]");
    }

    public WebElement getSkuLabel(int itemIndex){
        return byXpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr["+itemIndex+"]/td[2]/small[1]");
    }

    public WebElement getProductTotalPriceLabel(int itemIndex){
        return byXpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr["+itemIndex+"]/td[6]/span");
    }

    public WebElement getSubTotalCartPriceLabel(){
        return byId("total_product");
    }

    public WebElement getShippingPriceLabel(){
        return byId("total_shipping");
    }

    public WebElement getTotalPriceWithoutTaxLabel(){
        return byId("total_price_without_tax");
    }

    public WebElement getTaxPriceLabel(){
        return byId("total_tax");
    }

    public WebElement getTotalPriceLabel(){
        return byId("total_price");
    }

}