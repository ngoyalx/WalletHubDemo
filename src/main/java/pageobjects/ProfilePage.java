package pageobjects;

import common.ProjectProperty;
import org.openqa.selenium.WebElement;
import utils.SeleniumHandles;

/**
 * Created by ngoyal on 27/07/17.
 */
public class ProfilePage extends SeleniumHandles {

    public ProfilePage(){

    }

    public boolean verifyReviewText(){
        WebElement reviewTextArea = waitForElementToBeVisible(projectProperty.walletHubORData,"ProfilePage","activity");

        if(reviewTextArea.getText().equals(ReviewPage.randomString)){
            return true;
        }else{
            return false;
        }
    }
}
