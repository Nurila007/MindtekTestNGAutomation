package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppCreateAccountPage;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

import java.io.IOException;
import java.util.Random;

public class StoreRegistrationFunctionalityTests extends TestBase {

    String email;
    String password;

    @DataProvider(name="signUpDataProvider")
    public static Object[][] testData(){
        Object[][] data=new Object[][]{
                {"John","Doe","123456789",DataUtils.generateRandomNumber(30)+"","1","2021","123 Clark st.","Chicago","13","12345","21","123456789"},//set1
                {"Kim","Yi","absdefg","1","12","1988","2 MyRoad st.","New York","32","54321","21","987654321"},//set2
                {"Patel","Harsh","absdefg","1","12","1988","2 MyRoad st.","New York","32","54321","21","987654321"}//set3
        };
        return data;
    }

    @Test(dataProvider = "signUpDataProvider",groups = {"regression","smoke"})

    public void test1(String firstName,String lastName,String password,String day,String month,String year,
                      String address,String city,String state,String zipCode,String county,String phonemobileBox) throws IOException {
        StoreAppHomePage storeAppHomePage=new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage=new StoreAppLoginPage();
        StoreAppCreateAccountPage storeAppCreateAccountPage=new StoreAppCreateAccountPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));


        storeAppHomePage.loginButton.click();
        email=DataUtils.generateEmail();

        //we put DataUtils instead of random data object
        storeAppLoginPage.emailBox.sendKeys(email);
        storeAppLoginPage.submitButton.click();
       // storeAppCreateAccountPage.gender.click();
        storeAppCreateAccountPage.FirstNameBox.sendKeys(firstName);
        storeAppCreateAccountPage.LastNameBox.sendKeys(lastName);
        this.password=password;
        storeAppCreateAccountPage.PasswordBox.sendKeys(password);


        Select select=new Select(storeAppCreateAccountPage.daysBox);
        select.selectByValue("1");
        //WE CALL BROWSERUTILS CLASS
        BrowserUtils.selectByValue(storeAppCreateAccountPage.daysBox,day);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.monthsBox,month);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.yearsBox,year);
        storeAppCreateAccountPage.address1Box.sendKeys(address);
        storeAppCreateAccountPage.cityBox.sendKeys(city);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.stateBox,state);
        storeAppCreateAccountPage.postcodeBox.sendKeys(zipCode);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.countryBox,county);
        storeAppCreateAccountPage.phonemobileBox.sendKeys(phonemobileBox);

        storeAppCreateAccountPage.registerButton.click();

        BrowserUtils.takeScreenShot("signUpValidation");
        String actualTitle=driver.getTitle();
        String expectedTitle="My account - My Store";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    //we r going to test login functionality

    @Test(dependsOnMethods = {"test1"},groups = {"regression","smoke"})  // it will run test1 first and then test 2.
    public void test2() throws IOException {
        StoreAppHomePage storeAppHomePage=new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage=new StoreAppLoginPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.loginButton.click();
        storeAppLoginPage.loginEmailBox.sendKeys(email);
        storeAppLoginPage.loginPasswordBox.sendKeys(password);
        storeAppLoginPage.loginButton.click();
        BrowserUtils.takeScreenShot("loginValidation");

        String actualTitle=driver.getTitle();
        String expectedTitle= "My account - My Store";
        Assert.assertEquals(actualTitle,expectedTitle,"Title for log in didn't match.");

    }



}
