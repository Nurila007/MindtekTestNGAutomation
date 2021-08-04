package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    //default-->we don't have access to default variables from diffretent package
    // protected-->is accessible in differetnt package only if class is subclass
    //public--> is accessible everywhere, so we can make public or protected
   protected WebDriver driver;

    @BeforeMethod(groups = {"regression","smoke"})
    public void setUp(){
        driver=Driver.getDriver();
    }

    @AfterMethod(groups = {"regression","smoke"})
    public void tearDown() throws InterruptedException {
        //we put thread method because just want to see how it works, but in real work time we would't need it
        Thread.sleep(3000);
        driver.quit();
    }
}
