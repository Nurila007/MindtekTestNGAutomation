package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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



}
