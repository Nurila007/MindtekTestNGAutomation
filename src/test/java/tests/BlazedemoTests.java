package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazedemoFlightsPage;
import pages.BlazedemoHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.List;

public class BlazedemoTests  extends TestBase {

    /*
    1.@Test
     */



    @Test(groups = {"regression"})
    public void test1() {
        BlazedemoHomePage blazedemoHomePage=new BlazedemoHomePage();
        BlazedemoFlightsPage blazedemoFlightsPage=new BlazedemoFlightsPage();

        // have to navigate to URL
        driver.get(ConfigReader.getProperty("BlazedemoURL"));

        blazedemoHomePage.findFlightButton.click();
        //validate all prices in table are below $1000
        List<WebElement> prices = blazedemoFlightsPage.prices;
        for (WebElement element : prices) {

            String priceStr = element.getText();
            //now we have to convert to int, to now less then $1000
            //we can use parseInt method to convert string to integer
            //$472.56-->we have to remove $sign to convert to string
            priceStr = priceStr.substring(1);//WITH SUBSTRING WE REMOVED $SIGN
            double priceDouble = Double.parseDouble(priceStr);//"472.56"-->472.56

            Assert.assertTrue(priceDouble < 1000);
            //so this is OUR FIRST TEST CASE FOR BLAZEDEMO

        }
    }
        @Test(groups = {"regression"})
        public void test2(){

            BlazedemoHomePage blazedemoHomePage=new BlazedemoHomePage();
            BlazedemoFlightsPage blazedemoFlightsPage=new BlazedemoFlightsPage();
            driver.get(ConfigReader.getProperty("BlazedemoURL"));
            //then we have to create an select object for dropdown button to select
            //then we have to create dropdown webelement


            Select select=new Select(blazedemoHomePage.fromCityDropdown);
            select.selectByVisibleText("Boston");
            select = new Select(blazedemoHomePage.toCityDropdown);
            select.selectByVisibleText("London");
            blazedemoHomePage.findFlightButton.click();
            String actualText=blazedemoFlightsPage.headerText.getText();
            String expectedText="Flights from Boston to London:";
            Assert.assertEquals(actualText,expectedText);



    }
}
