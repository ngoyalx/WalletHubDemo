package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.*;
import utils.DriverFactory;

/**
 * Created by ngoyal on 26/07/17.
 */
public class WalletHubTest {



     DriverFactory browserFactory = new DriverFactory();
     WalletHubInsurancePage insurancePage;
     ReviewPage reviewPage;
     ConfirmationPage confirmationPage;
     ProfilePage profilePage;


    /**
     * Will open the browser(as per the config.properties file)
     * before starting the test
     */

    @BeforeTest
    public void setup(){
        browserFactory.openBrowser();
        insurancePage = new WalletHubInsurancePage();
    }


    /**
     * will verify if the review process is successful
     */

    @Test
    public void verifyReviewSubmission(){
        insurancePage.gotoTestInsuranceCompanyPage();
        insurancePage.login();
        reviewPage = insurancePage.giveStarRating();
        reviewPage.selectPolicyDropdown();
        confirmationPage = reviewPage.writeReview();
        Assert.assertTrue(confirmationPage.verifyConfirmationText());
    }


    /**
     * This test will execute only if the review submission proceess is
     * successful. Will verify is the same text is posted in the activity section
     * that was posted at the time of review submission
     */

    @Test(dependsOnMethods = {"verifyReviewSubmission"})
    public void validateReviewText(){
        profilePage = confirmationPage.gotoProfile();
        Assert.assertTrue(profilePage.verifyReviewText());
    }


    /**
     * will close the browser after the test is successful
     */
    @AfterTest
    public void tearDown(){
        browserFactory.closeBrowser();
    }
}
