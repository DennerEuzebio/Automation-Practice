package TestBases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.DriverManager;
import utils.DriverType;
import utils.FileOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.Report;

import java.io.IOException;

public class TestBase extends DriverManager{

    protected static ExtentTest test;
    static ExtentReports report;

    public static WebDriver getDriver(){
        return getDriver(DriverType.CHROME);
    }

    @BeforeEach
    public void setUp() {
        String index = FileOperations.getProperties("Paths").getProperty("url.home");
        getDriver().get(index);
    }

    @AfterEach
    public void tearDown() throws IOException {
        quitDriver();
        Report.close();
        FileOperations.flushProperties("ProductsData");
    }

}
