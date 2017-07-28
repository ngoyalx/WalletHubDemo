package pageobjects;

import org.openqa.selenium.interactions.*;
import org.openqa.selenium.WebElement;
import utils.SeleniumHandles;

import java.awt.*;

/**
 * Created by ngoyal on 27/07/17.
 */
public class FaceBookStatusPage extends SeleniumHandles {

    public FaceBookStatusPage(){


    }

    /**
     * will verify if the user is landed to the correct page after login
     * @return
     */
    public boolean verifyPageTitle(){
        if(driver.getTitle().equalsIgnoreCase("Facebook")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * will post a facebook status message as per the config.properties file
     */
    public void postSatusMessage(){

        try{
        Thread.sleep(6000);
        clickElementBasedOnCordinates();

        WebElement postStatusBox = waitForElementToBeVisible(projectProperty.faceBookORData,"FacebookWall","statusbox");
        postStatusBox.click();
        Thread.sleep(4000);

        WebElement statusPopup = driver.findElement(getByLocator(projectProperty.faceBookORData,"FacebookWall","statusboxpopup"));
        statusPopup.click();

        sendKeysUsingActionsClass(statusPopup,projectProperty.getPropertyFromglobalHashMap("facebookstatusMessage"));
        Thread.sleep(3000);

        WebElement postButton = waitForElementToBeVisible(projectProperty.faceBookORData,"FacebookWall","postbutton");
        postButton.click();
        Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
