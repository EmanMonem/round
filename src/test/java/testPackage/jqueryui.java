package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class jqueryui {
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
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html]");
        By locateCountry = By.xpath("//td[contains(text(),'Austria')]");
        String actualResult = driver.findElement(locateCountry).getText();
        String expectedResult = "Austria";
        Assert.assertEquals(actualResult,expectedResult);

    }
}
