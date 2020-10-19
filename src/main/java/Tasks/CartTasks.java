package Tasks;

import org.openqa.selenium.WebDriver;

public class CartTasks extends TasksAbstraction{


    public CartTasks(WebDriver driver) {
        super(driver);
    }

    public void validateCart(int howMuchItens){
        pages.accessOrderPage();
        for (int i = 1; i <= howMuchItens; i++) {
            System.out.println(i);
            orderValidation.validateUnitPrice(i);
            orderValidation.validateProductTotal(i);
            orderValidation.validateQuantity(i);
            orderValidation.validateSku(i);
        }
        orderValidation.validateTotalCartPrice(howMuchItens);
    }

    public void validateCartSHOULDFAIL(int howMuchItens){
        pages.accessOrderPage();
        for (int i = 1; i <= howMuchItens; i++) {
            System.out.println(i);
            orderValidation.validateUnitPrice(i);
            orderValidation.validateProductTotal(i);
            orderValidation.validateQuantity(i);
            orderValidation.validateSku(i);
        }
        orderValidation.validateTotalCartPriceSHOULDFAIL(howMuchItens);
    }
}
