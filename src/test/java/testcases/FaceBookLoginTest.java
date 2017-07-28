package testcases;

import common.ProjectProperty;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.FaceBookLogin;
import pageobjects.FaceBookStatusPage;
import utils.DriverFactory;
import utils.SeleniumHandles;

/**
 * Created by ngoyal on 23/07/17.
 */
public class FaceBookLoginTest {


     FaceBookLogin faceBookLogin;
     FaceBookStatusPage faceBookStatusPage;
     DriverFactory browserFactory = new DriverFactory();


    /**
     * will open the browser before the test
     */

    @BeforeTest
    public void setup(){
        browserFactory.openBrowser();
        faceBookLogin = new FaceBookLogin();
    }

    /**
     * will verify the facebook login
     */

    @Test
    public void verifyFaceBookLogin(){
        faceBookStatusPage = faceBookLogin.Login();
    }

    /**
     * will verify is the message as per the config.properties file
     * has been posted as facebook status message.
     */
    @Test(dependsOnMethods = {"verifyFaceBookLogin"})
    public void verifyStatusMessage(){
        Assert.assertTrue(faceBookStatusPage.verifyPageTitle());
        faceBookStatusPage.postSatusMessage();
    }


    /**
     * will close the browser after the test
     */

    @AfterTest
    public void tearDown(){
        DriverFactory.closeBrowser();
    }





}
