package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class FireFoxeTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        FirefoxOptions options = new FirefoxOptions();

        //options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("start-maximized");
        driver = new FirefoxDriver(options);
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
        driver.navigate().to("https://duckduckgo.com/");
        By searchTextBox =By.xpath("//input[@id='searchbox_input']");
        By fourthResult = By.xpath("//span[contains(text(),'TestNG Tutorial')]");
        driver.findElement(searchTextBox).sendKeys("TestNG",Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fourthResult));
        String expectedResult = "TestNG Tutorial";
        String actualResult = driver.findElement(fourthResult).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
