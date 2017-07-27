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



    @BeforeTest
    public void setup(){
        browserFactory.openBrowser();
        faceBookLogin = new FaceBookLogin();
    }

    @Test
    public void verifyFaceBookLogin(){
        faceBookStatusPage = faceBookLogin.Login();
    }

    @Test(dependsOnMethods = {"verifyFaceBookLogin"})
    public void verifyStatusMessage(){
        Assert.assertTrue(faceBookStatusPage.verifyPageTitle());
        faceBookStatusPage.postSatusMessage();
    }


    @AfterTest
    public void tearDown(){
        DriverFactory.closeBrowser();
    }





}
