package TestCases;

import Tasks.AddToCartTasks;
import Tasks.AuthenticationTasks;
import Tasks.CheckoutTasks;
import support.TestBase;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import support.Report;

import java.io.IOException;

public class BuyAnItemBasic extends TestBase {

    private final WebDriver DRIVER = getDriver();
    AddToCartTasks addToCartTasks = new AddToCartTasks(DRIVER);
    AuthenticationTasks authenticationTasks = new AuthenticationTasks(DRIVER);
    CheckoutTasks checkoutTasks = new CheckoutTasks(DRIVER);

    @Test
    @DisplayName("Create an user and buy an item FAIL. Basic test.")
    public void ChoseAnItemCreateALoginAndFinishThePurchase() throws IOException {
        try {
            Report.createTest("Fail buying an item");

            addToCartTasks.addProductsToCart(1);
            addToCartTasks.proceedToCheckout();
            authenticationTasks.createNewUser();
            checkoutTasks.validadeUserDataCreateUserFAIL();
            checkoutTasks.finishPurchase();
        } catch (Exception e) {
            Report.log(Status.ERROR, e.getMessage(), Report.fullPage(driver));
            throw e;
        }


    }

    @Test
    @DisplayName("Create an user and buy an item SUCCESS. Basic test.")
    public void ChoseAnItemCreateALoginAndFinishThePurchaseFAIL() throws IOException {
        try {
            Report.createTest("Successfully buy an item");

            addToCartTasks.addProductsToCart(1);
            addToCartTasks.proceedToCheckout();
            authenticationTasks.createNewUser();
            checkoutTasks.validadeUserDataCreateUser();
            checkoutTasks.finishPurchase();
        } catch (Exception e) {
            Report.log(Status.ERROR, e.getMessage(), Report.fullPage(driver));
            throw e;
        }
    }

}
