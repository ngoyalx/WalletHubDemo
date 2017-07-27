package pageobjects;

import org.openqa.selenium.WebElement;
import utils.SeleniumHandles;

/**
 * Created by ngoyal on 27/07/17.
 */
public class ConfirmationPage extends SeleniumHandles {

    public ConfirmationPage(){

    }


    public boolean verifyConfirmationText(){
        WebElement confirmationMessage = waitForElementToBeVisible(projectProperty.walletHubORData,"ConfirmationPage","confirmationtext");
        String actualConfirmationText = confirmationMessage.getText();

        if(actualConfirmationText.contains(projectProperty.getPropertyFromglobalHashMap("wallethubConfirmationText"))){
            return true;
        }else{
            return false;
        }
    }

    public ProfilePage gotoProfile(){
        WebElement userMenu = driver.findElement(getByLocator(projectProperty.walletHubORData,"ConfirmationPage","usermenu"));
        mouseHoverElement(userMenu);

        WebElement profileMenu = waitForElementToBeVisible(projectProperty.walletHubORData,"ConfirmationPage","profilemenu");
        profileMenu.click();
        return new ProfilePage();
    }
}
