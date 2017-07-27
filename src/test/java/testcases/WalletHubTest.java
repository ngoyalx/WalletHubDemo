package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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



    @BeforeTest
    public void setup(){
        browserFactory.openBrowser();
        insurancePage = new WalletHubInsurancePage();
    }


    @Test
    public void verifyReviewSubmission(){
        insurancePage.gotoTestInsuranceCompanyPage();
        insurancePage.login();
        reviewPage = insurancePage.giveStarRating();
        reviewPage.selectPolicyDropdown();
        confirmationPage = reviewPage.writeReview();
        Assert.assertTrue(confirmationPage.verifyConfirmationText());
    }



    @Test(dependsOnMethods = {"verifyReviewSubmission"})
    public void validateReviewText(){
        profilePage = confirmationPage.gotoProfile();
        Assert.assertTrue(profilePage.verifyReviewText());
    }


    @AfterTest
    public void tearDown(){
        browserFactory.closeBrowser();
    }
}
