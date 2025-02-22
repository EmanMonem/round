package testPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class saucedemo {

    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        var userNameTextBox = driver.findElement(By.xpath("//input[@id='user-name']"));
        userNameTextBox.sendKeys("standard_user");
        var passwordElementTextBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordElementTextBox.sendKeys("secret_sauce");
        var submitButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        submitButton.click();
        var addToCardButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCardButton.click();




    }
}
