package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.SeverityLevel;
import utils.DriverFactory;
import Listeners.CustomListener;

/**
 * Created by ngoyal on 26/07/17.
 */
@Listeners(CustomListener.class)
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
    @Features("WalletHub - Provide rating and review")

    @Step("Open Url, Login, Provide rating, Select policy drop down, write review, click Submit button")
    @Severity(SeverityLevel.CRITICAL)
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
    @Features("WalletHub - Verify if the review is Posted on the activity page")
    @Step("Go to the activity page after posting the review, Verify if the same review is displayed")
    @Severity(SeverityLevel.NORMAL)
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
