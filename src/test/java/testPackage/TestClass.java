package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestClass {

    WebDriver  driver;

    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();

        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("start-maximized");
        driver = new ChromeDriver(options);
        Wait<WebDriver> wait;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class);

    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void test1(){
        driver.navigate().to("https://duckduckgo.com/");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"Google");


    }
    @Test
    public void test2() {
        driver.navigate().to("https://duckduckgo.com/");

        //driver.findElement(By.xpath("//section[contains(@class, 'header_headerLeft__rW6nD')]/a")).click();
        //element.click();
        By logo = By.xpath("//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a/img");
//
        Assert.assertTrue(driver.findElement(logo).isDisplayed());
//

    }
    @Test
    public void test3(){
        driver.navigate().to("https://duckduckgo.com/");
        By searchTextBox =By.xpath("//input[@id='searchbox_input']");
        By firstResult = By.xpath("//*[@id=\"r1-0\"]");
        driver.findElement(searchTextBox).sendKeys("Selenium WebDriver",Keys.ENTER);
        driver.findElement(firstResult).click();
        String expectedResult = "https://www.selenium.dev/documentation/webdriver/";
        String actualResult = driver.getCurrentUrl(); //return https://www.selenium.dev/documentation/webdriver/troubleshooting/
        Assert.assertEquals(actualResult,expectedResult);
    }

}
