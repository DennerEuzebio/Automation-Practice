package TestCases;

import Tasks.AddToCartTasks;
import Tasks.AuthenticationTasks;
import Tasks.CartTasks;
import Tasks.CheckoutTasks;
import TestBases.TestBase;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.Report;

import java.io.IOException;

public class BuyMultiplesItens extends TestBase {

    private final WebDriver DRIVER = getDriver();
    AddToCartTasks addToCartTasks = new AddToCartTasks(DRIVER);
    AuthenticationTasks authenticationTasks = new AuthenticationTasks(DRIVER);
    CheckoutTasks checkoutTasks = new CheckoutTasks(DRIVER);
    CartTasks cartTasks = new CartTasks(DRIVER);

    @Test
    @DisplayName("Login and buy multiples itens SUCCESS.")
    public void ChoseMultiplesItensLoginAndFinishThePurchase() throws IOException {
        try {
            Report.createTest("Successfully buy multiples itens");

            int howMuchItensToAddToCart = 2;

            addToCartTasks.addProductsToCart(howMuchItensToAddToCart);
            cartTasks.validateCart(howMuchItensToAddToCart);
            addToCartTasks.proceedToCheckout();
            authenticationTasks.login();
            checkoutTasks.validadeUserDataLogin();
            checkoutTasks.finishPurchase();
        } catch (Exception e) {
            Report.log(Status.ERROR, e.getMessage(), Report.fullPage(driver));
            throw e;
        }

    }

    @Test
    @DisplayName("Login and buy multiples itens FAIL.")
    public void ChoseMultiplesItensLoginAndFinishThePurchaseFAIL() throws IOException {
        try {
            Report.createTest("Fail buying multiples itens");

            int howMuchItensToAddToCart = 3;

            addToCartTasks.addProductsToCart(howMuchItensToAddToCart);
            cartTasks.validateCartSHOULDFAIL(howMuchItensToAddToCart);
            addToCartTasks.proceedToCheckout();
            authenticationTasks.login();
            checkoutTasks.validadeUserDataLogin();
            checkoutTasks.finishPurchase();
        } catch (Exception e) {
            Report.log(Status.ERROR, e.getMessage(), Report.fullPage(driver));
            throw e;
        }
    }
}
