package Tasks;

import PageObjects.PageObjectsAbstraction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.FileOperations;

import java.io.IOException;

public class AddToCartTasks extends TasksAbstraction {

    PageObjectsAbstraction pageObjectsAbstraction;

    public AddToCartTasks(WebDriver driver) {
        super(driver);
        pageObjectsAbstraction = new PageObjectsAbstraction(driver);
    }

    public void addProductsToCart(int howMuch) throws IOException {
        for (int i = 1; i < howMuch+1; i++) {
            homePage.getProduct(i).click();
            saveProductInfo(i);
            productPage.getAddToCartButton().click();
            modalsPage.getContinueShoppingButton().click();
            pageObjectsAbstraction.waitLoad(homePage.getHomeLogo());
            homePage.getHomeLogo().click();
        }
    }

    public void proceedToCheckout() {
        homePage.getCartCollapse().click();
        orderPage.getProceedToCheckoutButton().click();
    }

    public void saveProductInfo(int itemIndex) throws IOException {
        FileOperations.setProperties("ProductsData","product."+itemIndex+".price",
                productPage.getProductPrice().getAttribute("innerText").substring(1));

        FileOperations.setProperties("ProductsData","product."+itemIndex+".sku",
                productPage.getSku().getAttribute("innerText"));

        FileOperations.setProperties("ProductsData","product."+itemIndex+".name",
                productPage.getProductName().getAttribute("innerText"));

        FileOperations.setProperties("ProductsData","product."+itemIndex+".quantity",productPage.getProductQuantity().getAttribute("value"));


        FileOperations.setProperties("ProductsData","product."+itemIndex+".total",calculateProductTotal(itemIndex));
    }

    public String calculateProductTotal(int itemIndex){
        double unitPrice = Double.parseDouble(FileOperations.getProperties("ProductsData")
                .getProperty("product."+itemIndex+".price"));

        int quantity = Integer.parseInt(FileOperations.getProperties("ProductsData")
                .getProperty("product."+itemIndex+".quantity"));

        double total = unitPrice*quantity;
        return String.format("%.2f",total);
    }


}
