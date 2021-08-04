package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlazedemoHomePage {

    //@Findby

    public BlazedemoHomePage(){

        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this); //this means this class(BlazedemoHomePage),it will find all we needed
        //web elements and initialise them

    }

    //this is our attribute, webelement type
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    public WebElement findFlightButton;

    //public Webelement findFlightElement=driver.findElement(By.xpath"//input[@class='btn btn-primary']");

    @FindBy(name="fromPort")

    public WebElement fromCityDropdown;

    @FindBy(name="toPort")
    public WebElement toCityDropdown;
    }


