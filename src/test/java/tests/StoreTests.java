package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StoreAppContactUsPage;
import pages.StoreAppHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

public class StoreTests extends TestBase {

    //we need to create an object out of StoreAppHomepage class


    @Test(groups = {"regression","smoke"})
    public void test1() {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppContactUsPage storeAppContactUsPage = new StoreAppContactUsPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.contactUsButton.click();

        //we have to create select object for dropdown
        Select select = new Select(storeAppContactUsPage.subjectHeadingDropdown);
        select.selectByValue("2");  //2 is customer service
        storeAppContactUsPage.email.sendKeys("123@gmail.com");

        //we have to upload file by using method sendKeys and provide the path
        //and we have to provide path NOT from our computer,so everybody will be able to get it, kollegi nawi ))
        //SO WE HAVE TO STORE THIS FILE IN OUR PROJECT,COPY IMAGE FILE , HAVE TO CRETATE TESTDATA FOLDER UNDER
        //RESOURCES

        //we have to get directories from our teammatates to this project, so have to automate it
        //find out path from teammates computer
        String projectPath = System.getProperty("user.dir");
        System.out.println("Path for our project is" + projectPath);

        storeAppContactUsPage.fileUpload.sendKeys(projectPath + "/src/test/resources/testdata/download.jpeg");

        storeAppContactUsPage.message.sendKeys("Hello World");
        storeAppContactUsPage.submitButton.click();
        //validate the success message
        String actualSuccessMessage = storeAppContactUsPage.successMessage.getText();
        String expectedSuccessMessage = "Your message has been successfully sent to our team.";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

    }
        //negative scenario for contactUs

        @Test(groups = {"regression","smoke"})
        public void test2(){
            StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
            StoreAppContactUsPage storeAppContactUsPage = new StoreAppContactUsPage();

            driver.get(ConfigReader.getProperty("StoreAppURL"));
            storeAppHomePage.contactUsButton.click();

            Select select = new Select(storeAppContactUsPage.subjectHeadingDropdown);
            select.selectByValue("2");  //2 is customer service
            storeAppContactUsPage.email.sendKeys("123@gmail.com");

            String projectPath = System.getProperty("user.dir");
            System.out.println("Path for our project is" + projectPath);

            storeAppContactUsPage.fileUpload.sendKeys(projectPath + "/src/test/resources/testdata/download.jpeg");

           storeAppContactUsPage.submitButton.click();

           String actualErrorMessage=storeAppContactUsPage.errorMessage.getText();
           String expectedErrorMessage="The message cannot be blank.";
           Assert.assertEquals(actualErrorMessage,expectedErrorMessage);


           //so when we run these 2 tests the second one will not be passed,
            //because we have generated pages for both of them in storeappcontactUspage and storeapphomepage
            //so to fix this issue we will need new driver object for test2, so in this case we put object
            //inside the @test method,not on top.



    }

        }




