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
        By firstResult = By.xpath("//span[contains(text(),'WebDriver - Selenium')]");
        driver.findElement(searchTextBox).sendKeys("Selenium WebDriver",Keys.ENTER);
        driver.findElement(firstResult).click();
        String expectedResult = "https://www.selenium.dev/documentation/webdriver/";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);

   }

    @Test
    public void test4(){
        driver.navigate().to("https://duckduckgo.com/");
        By searchTextBox =By.xpath("//input[@id='searchbox_input']");
        By fourthResult = By.xpath("//span[contains(text(),'TestNG Tutorial')]");
        driver.findElement(searchTextBox).sendKeys("TestNG",Keys.ENTER);
        String expectedResult = "TestNG Tutorial";
        String actualResult = driver.findElement(fourthResult).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void test5(){
        driver.navigate().to("https://duckduckgo.com/");
        By searchTextBox =By.xpath("//input[@id='searchbox_input']");
        By SecondResult = By.xpath("//span[contains(text(),'BDD Testing & Collaboration Tools for Teams')]");

        driver.findElement(searchTextBox).sendKeys("Cucumber IO",Keys.ENTER);
        driver.findElement(SecondResult).click();
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://www.linkedin.com";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

}
