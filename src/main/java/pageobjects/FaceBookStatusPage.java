package pageobjects;

import org.openqa.selenium.WebElement;
import utils.SeleniumHandles;

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
        WebElement postStatusBox = waitForElementToBeVisible(projectProperty.faceBookORData,"FacebookWall","statusbox");
        postStatusBox.click();
        postStatusBox.sendKeys(projectProperty.getPropertyFromglobalHashMap("facebookstatusMessage"));

        WebElement postButton = waitForElementToBeVisible(projectProperty.faceBookORData,"FacebookWall","postbutton");
        mouseHoverElement(postButton);
        System.out.println("<<<<<<<<Mousehover successfull>>>>>>>>>>>>>>>");
        //postButton.click();
    }

}
