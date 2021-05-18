package automationPractice;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutomationPractice {

    /*
    Homework - 3
    Open url : http://automationpractice.com/index.php
    Click on Sign In
    Enter correct Email in Email field
    Enter wrong Password in Password field
    Click on Sign In button.
    Expected Result:
    Error Message “There is 1 error”
     */

    WebDriver driver;
    @Before

    public void userNavigateToAutomationPractice(){

       String baseUrl="http://automationpractice.com/index.php";

       System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

       driver=new ChromeDriver();

       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.get(baseUrl);
    }


    @Test

    public void verifyUserGetErrorMessageWhenEnteredPasswordWrong(){

    driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
    driver.findElement(By.id("email")).sendKeys("nidsdhola@gmail.com");
    driver.findElement(By.id("passwd")).sendKeys("123*#");
    driver.findElement(By.xpath("//i[@class='icon-lock left']")).click();

    WebElement message=driver.findElement(By.xpath("//div[@class='alert alert-danger']//p[text()='There is 1 error']"));
    String actualMessage=message.getText();

    System.out.println("Error Message: "+actualMessage);

    }

}
