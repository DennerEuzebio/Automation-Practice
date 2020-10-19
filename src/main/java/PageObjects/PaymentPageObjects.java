package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPageObjects extends PageObjectsAbstraction {


    public PaymentPageObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement getTotalProductPriceLabel(){
        return byId("total_product_price_1_1_395119");
    }

    public WebElement getProductPriceLabel(){
        return byId("product_price_1_1_395119");
    }

    public WebElement getProductQuantityLabel(){
        return byXpath("//*[@id=\"product_1_1_0_395119\"]/td[5]/span");
    }

    public WebElement getProductNameLabel(){
        return byXpath("//*[@id=\"product_1_1_0_395119\"]/td[2]/p/a");
    }

    public WebElement getSubTotalLabel(){
        return byId("total_product");
    }

    public WebElement getShippingPriceLabel(){
        return byId("total_shipping");
    }

    public WebElement getTotalPriceLabel(){
        return byId("total_price");
    }

    public WebElement getBankWirePaymentButton(){
        return byXpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div");
    }

    public WebElement getCheckPaymentButton(){
        return byXpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div");
    }


}
