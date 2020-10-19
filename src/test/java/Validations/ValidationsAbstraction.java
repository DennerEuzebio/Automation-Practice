package Validations;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import support.Messages;
import support.Report;

public class ValidationsAbstraction extends Messages {

    protected WebDriver driver;

    public ValidationsAbstraction(WebDriver driver) {
        this.driver = driver;
    }

    protected void tryCatch(String expected, String actual, String messagePass, String messageFail, WebElement element){
        new Actions(driver).moveToElement(element).perform();
        try {
            if (!actual.equals(expected)) throw new Exception();
            Report.log(Status.PASS, messagePass, Report.capture(driver));
        } catch (Exception e){
            Report.log(Status.FAIL, messageFail, Report.fullPage(driver));
            Assertions.assertEquals(expected,actual);
        }
    }
}
