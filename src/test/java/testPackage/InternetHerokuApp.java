package testPackage;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InternetHerokuApp {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();

        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("start-maximized");
        driver = new ChromeDriver(options);
        Wait<WebDriver> wait;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class);

    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
    @Test
    public void test1(){
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
        By checkBox1 = By.xpath("//form[@id='checkboxes']/input[1]");
        By checkBox2 = By.xpath("//form[@id='checkboxes']/input[2]");
        driver.findElement(checkBox1).click();
        boolean checkBox1IsChecked = driver.findElement(checkBox1).isSelected();
        boolean checkBox2IsChecked = driver.findElement(checkBox2).isSelected();
        Assert.assertTrue(checkBox1IsChecked);
        Assert.assertTrue(checkBox2IsChecked);

    }

    @Test
    public void test2(){
        driver.navigate().to("http://the-internet.herokuapp.com/upload");
        By chooseFileButton = By.xpath("//input[@id='file-upload']");
        By uploadButton = By.xpath("//input[@id='file-submit']");
        By fileUploadMSG = By.xpath("//h3[contains(text(),'File Uploaded!')]");
        String filePath = "C:\\Users\\eman.mohamed\\Desktop\\CC.png";
        driver.findElement(chooseFileButton).sendKeys(filePath);
        driver.findElement(uploadButton).click();
        boolean fileUploadMSGIsDisplayed = driver.findElement(fileUploadMSG).isDisplayed();
        Assert.assertTrue(fileUploadMSGIsDisplayed);


    }
}
