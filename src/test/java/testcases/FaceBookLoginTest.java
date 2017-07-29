package testcases;


import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.FaceBookLogin;
import pageobjects.FaceBookStatusPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import utils.DriverFactory;
import Listeners.CustomListener;


/**
 * Created by ngoyal on 23/07/17.
 */

@Listeners(CustomListener.class)
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
    @Features("Facebook Login")
    @Stories("Login with valid credentials")
    @Step("User open Facebook.com, enter credentials, click on login button")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyFaceBookLogin(){
        faceBookStatusPage = faceBookLogin.Login();
        Assert.assertTrue(faceBookStatusPage.verifyPageTitle());
    }

    /**s
     * will verify is the message as per the config.properties files
     * has been posted as facebook status message.
     */
    @Test(dependsOnMethods = {"verifyFaceBookLogin"})
    @Features("Post Status Message")
    @Stories("Post status messsage - Hello World")
    @Step("User write a status message, click on Post button")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyStatusMessage(){
        Assert.assertTrue(faceBookStatusPage.postStatusMessage());
    }


    /**
     * will close the browser after the test
     */

    @AfterTest
    public void tearDown(){
        DriverFactory.closeBrowser();
    }





}
