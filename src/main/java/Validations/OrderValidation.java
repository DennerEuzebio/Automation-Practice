package Validations;

import PageObjects.OrderPage;
import org.openqa.selenium.WebDriver;
import utils.FileOperations;
import utils.Messages;
import org.junit.jupiter.api.Assertions;

public class OrderValidation extends ValidationsAbstraction {


    private final OrderPage ORDER_PAGE;

    public OrderValidation(WebDriver driver) {
        super(driver);
        ORDER_PAGE = new OrderPage(driver);
    }

    public void validateUnitPrice(int itemIndex){
        System.out.println(itemIndex);
        String expected = FileOperations.getProperties("ProductsData").getProperty("product."+itemIndex+".price");
        String actual = ORDER_PAGE.getProductUnitPriceLabel(itemIndex).getAttribute("innerText").substring(1);
        tryCatch(expected,actual, Messages.unitPriceCartConfirmationPass(),
                Messages.unitPriceCartConfirmationFail(expected, actual),
                ORDER_PAGE.getProductUnitPriceLabel(itemIndex));
    }

    public void validateQuantity(int itemIndex){
        String expected = FileOperations.getProperties("ProductsData").getProperty("product."+itemIndex+".quantity");
        String actual = ORDER_PAGE.getProductQuantityInput(itemIndex).getAttribute("value");
        tryCatch(expected,actual, Messages.quantityCartConfirmationPass(),
                Messages.quantityCartConfirmationFail(expected, actual),
                ORDER_PAGE.getProductQuantityInput(itemIndex));
    }

    public void validateSku(int itemIndex){
        String expected = FileOperations.getProperties("ProductsData").getProperty("product."+itemIndex+".sku");
        String actual = ORDER_PAGE.getSkuLabel(itemIndex).getAttribute("innerText").substring(6);
        Assertions.assertEquals(expected,actual);
        tryCatch(expected,actual, Messages.skuCartConfirmationPass(),
                Messages.skuCartConfirmationFail(expected, actual),
                ORDER_PAGE.getSkuLabel(itemIndex));
    }

    public void validateProductTotal(int itemIndex){
        String expected = FileOperations.getProperties("ProductsData").getProperty("product."+itemIndex+".total");
        String actual = ORDER_PAGE.getProductTotalPriceLabel(itemIndex).getAttribute("innerText").substring(1);
        tryCatch(expected,actual, Messages.productTotalCartConfirmationPass(),
                Messages.productTotalCartConfirmationFail(expected, actual),
                ORDER_PAGE.getSkuLabel(itemIndex));
    }

    public void validateTotalCartPrice(int howMuchItens){
        double subTotal = 0;
        for (int i = 1; i <= howMuchItens; i++) {
            subTotal += Double.parseDouble(FileOperations.getProperties("ProductsData")
                    .getProperty("product."+i+".total"));
        }

        String expected = String.format("%.2f",subTotal);
        String actual = ORDER_PAGE.getSubTotalCartPriceLabel().getAttribute("innerText").substring(1);
        tryCatch(expected,actual, Messages.totalCartPriceConfirmationPass(),
                Messages.totalCartPriceConfirmationFail(expected, actual),
                ORDER_PAGE.getSubTotalCartPriceLabel());
    }

    public void validateTotalCartPriceSHOULDFAIL(int howMuchItens){
        double subTotal = 0;
        for (int i = 1; i <= howMuchItens; i++) {
            subTotal += Double.parseDouble(FileOperations.getProperties("ProductsData")
                    .getProperty("product."+i+".total"));
        }
//      This line create the fail
        subTotal += 3;

        String expected = String.format("%.2f",subTotal);
        String actual = ORDER_PAGE.getSubTotalCartPriceLabel().getAttribute("innerText").substring(1);
        tryCatch(expected,actual, Messages.totalCartPriceConfirmationPass(),
                Messages.totalCartPriceConfirmationFail(expected, actual),
                ORDER_PAGE.getSubTotalCartPriceLabel());
    }

}
