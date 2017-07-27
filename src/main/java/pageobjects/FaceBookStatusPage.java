package pageobjects;

import org.openqa.selenium.WebElement;
import utils.SeleniumHandles;

/**
 * Created by ngoyal on 27/07/17.
 */
public class FaceBookStatusPage extends SeleniumHandles {

    public FaceBookStatusPage(){

    }

    public boolean verifyPageTitle(){
        if(driver.getTitle().equalsIgnoreCase("Facebook")){
            return true;
        }else{
            return false;
        }
    }

    public void postSatusMessage(){
        WebElement postStatusBox = waitForElementToBeVisible(projectProperty.faceBookORData,"FacebookWall","statusbox");
        postStatusBox.click();
        postStatusBox.sendKeys(projectProperty.getPropertyFromglobalHashMap("facebookstatusMessage"));

        WebElement postButton = waitForElementToBeVisible(projectProperty.faceBookORData,"FacebookWall","postbutton");
        postButton.click();
    }

}
