package Tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FileOperations;

import java.io.IOException;

public class AddToCartTasks extends TasksAbstraction {

    public AddToCartTasks(WebDriver driver) {
        super(driver);
    }

    public void addProductsToCart(int howMuch) throws IOException {
        for (int i = 1; i < howMuch+1; i++) {
            pages.accessHomePage();
            homePage.getProduct(i).click();
            saveProductInfo(i);
            productPage.getAddToCartButton().click();
            modalsPage.getProceedToCheckouButton();
        }
    }

    public void proceedToCheckout() {
        pages.accessOrderPage();
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
