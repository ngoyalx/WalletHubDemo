package testcases;

import common.ProjectProperty;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.FaceBookLogin;
import utils.DriverFactory;
import utils.SeleniumHandles;

/**
 * Created by ngoyal on 23/07/17.
 */
public class FaceBookLoginTest {


    FaceBookLogin faceBookLogin;
    DriverFactory browserFactory = new DriverFactory();



    @BeforeTest
    public void setup(){
        browserFactory.openBrowser();
        faceBookLogin = new FaceBookLogin();
    }

    @Test
    public void verifyFaceBookLogin(){
        Assert.assertEquals(faceBookLogin.Login(),"Facebook");
    }

    @Test(dependsOnMethods = "verifyFaceBookLogin")
    public void printMessage(){
        faceBookLogin.postMessage();
    }


    @AfterTest
    public void tearDown(){
        DriverFactory.closeBrowser();
    }





}
