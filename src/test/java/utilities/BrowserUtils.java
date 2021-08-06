package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {


    /*
    method that will accept dropdown WebElement
    and value of that dropdown and it will select that value which is provided in parameter.
    ex;-->selectByValue(dropdown element, "1");-->void
     */
    //and also we have to make static , to avoid creating an object


    public static void selectByValue(WebElement element, String value){
        Select select=new Select(element);
        select.selectByValue(value);
    }


    /*
    this method will take a screenshot of browser
    *ex;
    .takeScreenShot("LoginTest");
     */

    public static void takeScreenShot(String name) throws IOException {
        WebDriver driver=Driver.getDriver();
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //store screenshot(put absolutepath from resources, screenshot package
        String path=System.getProperty("user.dir")+"/src/test/resources/screenshots/"+name+System.currentTimeMillis()+".png";
        File file=new File((path));
        FileUtils.copyFile(screenshot,file);



    }

    /*
    this method will wait untill element will clickable
    *Ex;--> .waitElementToBeClickable(element);-->return element;
     */

    public static WebElement waitElementToBeVisible(WebElement element){

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        WebElement element1=wait.until(ExpectedConditions.visibilityOf(element));
        return element1;
    }

    /*
    this method will scroll the page.
    *Ex;--> .scroll(250);
     */

    public static void scroll(int pixels){
        WebDriver driver=Driver.getDriver();
        JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("window.scrollBy(0,"+pixels+")");
        
    }




}
