package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppHomePage {

    //we have to create a constructor
    public StoreAppHomePage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    //then we have to create our findby method, to find webelement
    @FindBy(xpath = "//a[@title='Contact Us']")
    public WebElement contactUsButton;

    @FindBy(xpath = "//a[@class='login']")
    public WebElement loginButton;



}
