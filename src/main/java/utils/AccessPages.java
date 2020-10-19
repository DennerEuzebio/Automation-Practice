package utils;

import org.openqa.selenium.WebDriver;

public class AccessPages {

    private WebDriver driver;

    public AccessPages(WebDriver driver) {
        this.driver = driver;
    }

    public void accessOrderPage(){
        driver.get(FileOperations.getProperties("Paths").getProperty("url.order"));
    }

    public void accessHomePage(){
        driver.get(FileOperations.getProperties("Paths").getProperty("url.home"));
    }

    public void accessAuthenticationPage(){
        driver.get(FileOperations.getProperties("Paths").getProperty("url.authentication"));
    }
}
