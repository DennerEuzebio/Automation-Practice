package Tasks;

import PageObjects.*;
import Validations.CheckoutValidations;
import Validations.CreateUserFormValidation;
import Validations.OrderValidation;
import org.openqa.selenium.WebDriver;

public class TasksAbstraction {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ProductPage productPage;
    protected ModalsPage modalsPage;
    protected OrderPage orderPage;
    protected AuthenticationPage authenticationPage;
    protected CreateUserFormPage createUserFormPage;
    protected CreateUserFormValidation createUserFormValidation;
    protected AddressPage addressPage;
    protected ShippingPageObjects shippingPageObjects;
    protected PaymentPageObjects paymentPageObjects;
    protected PaymentConfirmationPageObjects paymentConfirmationPageObjects;
    protected CheckoutValidations checkoutValidations;
    protected OrderValidation orderValidation;

    public TasksAbstraction(WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(this.driver);
        productPage = new ProductPage(this.driver);
        modalsPage = new ModalsPage(this.driver);
        orderPage = new OrderPage(this.driver);
        authenticationPage = new AuthenticationPage(driver);
        createUserFormPage = new CreateUserFormPage(driver);
        createUserFormValidation = new CreateUserFormValidation(driver);
        addressPage = new AddressPage(driver);
        shippingPageObjects = new ShippingPageObjects(driver);
        paymentPageObjects = new PaymentPageObjects(driver);
        paymentConfirmationPageObjects = new PaymentConfirmationPageObjects(driver);
        checkoutValidations = new CheckoutValidations(driver);
        orderValidation = new OrderValidation(driver);
    }
}
