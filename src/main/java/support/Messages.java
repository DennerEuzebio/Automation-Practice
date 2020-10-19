package support;

public class Messages {

    public static String emailFormConfirmationTextboxFail(String expected, String actual) {
        return "The e-mail in the form don't match the e-mail generated. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String emailFormConfirmationTextboxPass() {
        return "The e-mail in the form match the e-mail generated.";
    }

    public static String firstNameFormConfirmationTextboxFail(String expected, String actual) {
        return "The first name field in the second part of the form don't match the name generated. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String firstNameFormConfirmationTextboxPass() {
        return "The first name field in the second part of the form match the name generated.";
    }

    public static String lastNameFormConfirmationTextboxFail(String expected, String actual) {
        return "The last name field in the second part of the form don't match the name generated. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String lastNameFormConfirmationTextboxPass() {
        return "The last name field in the second part of the form match the name generated.";
    }

    public static String namesCheckoutConfirmationTextboxFail(String expected, String actual){
        return "The name field in the address area are incorrect. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String namesCheckoutConfirmationTextboxPass(){
        return "The name field in the address area are correct.";
    }

    public static String adressCheckoutConfirmationTextboxFail(String expected, String actual){
        return "The adress field in the address area are incorrect. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String adressCheckoutConfirmationTextboxPass(){
        return "The adress field in the address area are correct.";
    }

    public static String companyCheckoutConfirmationTextboxFail(String expected, String actual){
        return "The company field in the address area are incorrect. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String companyCheckoutConfirmationTextboxPass(){
        return "The company field in the address area are correct.";
    }

    public static String phoneCheckoutConfirmationTextboxFail(String expected, String actual){
        return "The phone field in the address area are incorrect. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String phoneCheckoutConfirmationTextboxPass(){
        return "The phone field in the address area are correct.";
    }

    public static String unitPriceCartConfirmationFail(String expected, String actual){
        return "The unit price in the cart don't match the unit price in the product page. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String unitPriceCartConfirmationPass(){
        return "The unit price in the car  match the unit price in the product page.";
    }

    public static String quantityCartConfirmationFail(String expected, String actual){
        return "The quantity in the cart don't match the quantity in the product page. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String quantityCartConfirmationPass(){
        return "The quantity in the car  match the quantity in the product page.";
    }

    public static String skuCartConfirmationFail(String expected, String actual){
        return "The sku in the cart don't match the sku in the product page. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String skuCartConfirmationPass(){
        return "The sku in the cart match the sku in the product page.";
    }

    public static String productTotalCartConfirmationFail(String expected, String actual){
        return "The product total in the cart don't match the product total in the product page. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String productTotalCartConfirmationPass(){
        return "The product total in the cart match the product total in the product page.";
    }

    public static String totalCartPriceConfirmationFail(String expected, String actual){
        return "The total cart price don't match the product unit price times the quantity. " +
                "Expected: " + expected + " Actual: " + actual;
    }

    public static String totalCartPriceConfirmationPass(){
        return "The total cart price match the product unit price times the quantity.";
    }

}
