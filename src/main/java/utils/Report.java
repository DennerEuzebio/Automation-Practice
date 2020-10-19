package utils;

import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {

    public static final String PATH_REPORT = System.getProperty("user.dir") + File.separator + "Report" +  File.separator + "Report_"  + getDate();
    private static final String PATH_SCREENSHOT = PATH_REPORT + File.separator + "Screenshot";
    public static WebDriver driver;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static final ExtentReports extent = configReportExtent();

    public static void createTest(String testName) {
            ExtentTest extentTest = extent.createTest(testName);
            test.set(extentTest);
    }

    public static ExtentReports configReportExtent(){
        createFolderReport(PATH_REPORT);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(PATH_REPORT+ File.separator + "MyReport_" + getDate() + ".html");
        htmlReporter.config().setDocumentTitle("Relatorio de Execucao da Automacao");
        htmlReporter.config().setReportName("Relatorio de Execução dos Testes");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        return extentReports;
    }

    public static void createFolderReport(String path){
        File pathReport = new File(path);
        if(!pathReport.exists()){
            pathReport.mkdir();
        }
    }

    public static MediaEntityModelProvider fullPage(WebDriver driver) {
        try {
            PageSnapshot screenshot = Shutterbug.shootPage(driver);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            ImageIO.write(screenshot.getImage(), "png", stream);
            String base64image = Base64.encodeBase64String(stream.toByteArray());

            return MediaEntityBuilder.createScreenCaptureFromBase64String(base64image).build();
        } catch (ScreenshotException | IOException e) {
            String message = "Ocorreu uma falha na captura de tela.";
            Report.log(Status.WARNING, message);
        }

        return null;
    }

    public static MediaEntityModelProvider capture(WebDriver driver) {
        try {
            createFolderReport(PATH_SCREENSHOT);
            File scrshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = PATH_SCREENSHOT + File.separator + "Image_" + getDate() + ".png";
            FileUtils.copyFile(scrshot, new File(screenshotPath));
            return MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build();
        } catch (IOException e) {
            String message = "Ocorreu uma falha na captura de tela.";
            Report.log(Status.WARNING, message);
        }


        return null;
    }

    private static String getDate(){
        return new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
    }

    public static void log(Status status, String message, MediaEntityModelProvider capture) {
        if (existInstance()) {
            return;
        }
        test.get().log(status, message, capture);
    }

    public static void log(Status status, String message) {
        if (existInstance()) {
            return;
        }
        test.get().log(status, message);
    }

    private static boolean existInstance() {
        return test.get() == null;
    }
    public static void close() {
        if (existInstance()) {
            return;
        }
        extent.flush();
    }
}