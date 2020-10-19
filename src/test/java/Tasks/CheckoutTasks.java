package Tasks;

import PageObjects.AddressPage;
import PageObjects.PaymentConfirmationPageObjects;
import PageObjects.PaymentPageObjects;
import PageObjects.ShippingPageObjects;
import Validations.CheckoutValidations;
import org.openqa.selenium.WebDriver;

public class CheckoutTasks extends TasksAbstraction {


    public CheckoutTasks(WebDriver driver){
        super(driver);
    }

    public void validadeUserDataCreateUser(){
        checkoutValidations.validateNames();
        checkoutValidations.validateAddresses();
        checkoutValidations.validateCompany();
        checkoutValidations.validatePhoneMobile();
    }

    public void validadeUserDataCreateUserFAIL(){
        checkoutValidations.validateNamesSHOULDFAIL();
        checkoutValidations.validateAddresses();
        checkoutValidations.validateCompany();
        checkoutValidations.validatePhoneMobile();
    }

    public void validadeUserDataLogin(){
        homePage.getCartCollapse().click();
        orderPage.getProceedToCheckoutButton().click();
        checkoutValidations.validateNames();
        checkoutValidations.validateAddresses();
        checkoutValidations.validateCompany();
        checkoutValidations.validatePhoneMobile();
    }

    public void finishPurchase(){
        addressPage.getProceedToCheckoutButton().click();
        shippingPageObjects.getTermsCheckBox().click();
        shippingPageObjects.getProceedToCheckoutButton().click();
//        validação dos valores
        paymentPageObjects.getBankWirePaymentButton().click();
        paymentConfirmationPageObjects.getProceedToCheckoutButton().click();
    }

}
