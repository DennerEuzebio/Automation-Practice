package support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import support.DriverManager;
import support.DriverType;
import support.FileOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import support.Report;

import java.io.IOException;

public class TestBase extends DriverManager{

    public static WebDriver getDriver(){
        return getDriver(DriverType.CHROME);
    }

    @BeforeEach
    public void setUp() {
        String index = FileOperations.getProperties("Paths").getProperty("url.home");
        driver.manage().deleteAllCookies();
        getDriver().get(index);
    }

    @AfterEach
    public void tearDown() throws IOException {
        quitDriver();
        Report.close();
        FileOperations.flushProperties("ProductsData");
    }

}
