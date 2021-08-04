package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class RedshelfTest extends TestBase {

    /*
    1.@Beforemethod-->inherited from TestBase
    2.@AfterMethod-->inherited from TestBase
    3.@Test

    //driver-> inherited from TestBase class, so we did it protected(could make it public also) to get access from here
    */

    @Test(groups = {"regression"})
            public void test1(){
    driver.get("https://redshelf.com/");
    String expectedTitle="RedShelf";
    String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @Test(groups = {"regression","smoke"})
    public void test2(){
        driver.get("https://redshelf.com/");
        driver.findElement(By.id("search-catalog-navbar")).sendKeys("Java data structure"+ Keys.ENTER);
        driver.findElement((By.xpath("//a[@class='title text-book-title'][1]"))).click();
       String bookName=driver.findElement(By.xpath("//h1//span")).getText();
       String title=driver.getTitle();

       //we should validate that title starts with book name.
        Assert.assertTrue(title.startsWith(bookName)); //true/false


    }


}
