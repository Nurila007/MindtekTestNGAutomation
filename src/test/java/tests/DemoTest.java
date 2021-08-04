package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class DemoTest {
    WebDriver driver;

    @BeforeMethod
    public  void setUp(){

    driver= Driver.getDriver();

    }

    @Test
    public void test1() {
        driver.get(ConfigReader.getProperty("Guru99URL"));
        driver.findElement(By.id("email")).sendKeys(ConfigReader.getProperty("email"));
        driver.findElement(By.id("passwd")).sendKeys(ConfigReader.getProperty("password1"));
        driver.findElement(By.xpath("//*[@id='SubmitLogin']/span")).click();
        String expectedMessage = "Successfully Logged in...";
        String actualMessage = driver.findElement(By.xpath("//div[2]/div/div/h3")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }
@Test
    public void test2() {
        driver.get(ConfigReader.getProperty("Guru99URL"));
        driver.findElement(By.id("email")).sendKeys(ConfigReader.getProperty("userGuru99"));
        driver.findElement(By.id("passwd")).sendKeys(ConfigReader.getProperty("passGuru99"));
        driver.findElement(By.xpath("//*[@id='SubmitLogin']/span")).click();
        driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[7]/a")).click();
        driver.findElement(By.xpath("//*[@id='three']/div/form/div/div[8]/ul/li/input")).click();
        String expectedAmount = "$20.00";
        String actualAmount = driver.findElement(By.xpath("//*[@id='three']/div/form/div[1]/div/font[2]")).getText();
        Assert.assertEquals(actualAmount, expectedAmount);
        driver.findElement(By.id("card_nmuber")).sendKeys("1234123412341234");
        WebElement dropdown1 = driver.findElement(By.id("month"));
        Select select = new Select(dropdown1);
        select.selectByValue("3");
        WebElement dropdown2 = driver.findElement(By.id("year"));
        Select select1 = new Select(dropdown2);
        select1.selectByValue("2019");
        driver.findElement(By.id("cvv_code")).sendKeys("123");
        driver.findElement(By.name("submit")).click();
        String expectedWord = "Payment successfull!";
        String actualWord = driver.findElement(By.xpath("//div/h2")).getText();
        Assert.assertEquals(actualWord, expectedWord);
    }
    @Test
    public void test3() {
        driver.get(ConfigReader.getProperty("Guru99URL"));
        driver.findElement(By.id("email")).sendKeys(ConfigReader.getProperty("userGuru99"));
        driver.findElement(By.id("passwd")).sendKeys(ConfigReader.getProperty("passGuru99"));
        driver.findElement(By.xpath("//*[@id='SubmitLogin']/span")).click();
        driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[7]/a")).click();
        WebElement dropdown1 = driver.findElement(By.name("quantity"));
        Select select1 = new Select(dropdown1);
        select1.selectByValue("3");
        driver.findElement(By.xpath("//*[@id='three']/div/form/div/div[8]/ul/li/input")).click();
        String expectedAmount = "$60.00";
        String actualAmount = driver.findElement(By.xpath("//*[@id='three']/div/form/div[1]/div/font[2]")).getText();
        Assert.assertEquals(actualAmount, expectedAmount);
    }
    @Test
    public void test4 () {
        driver.get(ConfigReader.getProperty("Guru99URL"));
        driver.findElement(By.id("email")).sendKeys(ConfigReader.getProperty("userGuru99"));
        driver.findElement(By.id("passwd")).sendKeys(ConfigReader.getProperty("passGuru99"));
        driver.findElement(By.xpath("//*[@id='SubmitLogin']/span")).click();
        driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[7]/a")).click();
        driver.findElement(By.xpath("//*[@id='three']/div/form/div/div[8]/ul/li/input")).click();
        driver.findElement(By.id("card_nmuber")).sendKeys(ConfigReader.getProperty("invalidcardnumber"));
        WebElement dropdown1 = driver.findElement(By.id("month"));
        Select select = new Select(dropdown1);
        select.selectByValue("3");
        WebElement dropdown2 = driver.findElement(By.id("year"));
        Select select1 = new Select(dropdown2);
        select1.selectByValue("2019");
        driver.findElement(By.id("cvv_code")).sendKeys(ConfigReader.getProperty("cvvcode"));
        driver.findElement(By.name("submit")).click();
        Alert confirmation = driver.switchTo().alert();
        String actualConfirmationText = confirmation.getText();
        String expectedConfirmationText = "Check card number is 16 digits!";
        Assert.assertEquals(actualConfirmationText,expectedConfirmationText);
    }



    @AfterMethod
    public void tearDown(){

    }
}
