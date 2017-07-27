package pageobjects;

import org.openqa.selenium.WebElement;
import utils.JavaUtils;
import utils.SeleniumHandles;

/**
 * Created by ngoyal on 26/07/17.
 */
public class ReviewPage extends SeleniumHandles {

    public static String randomString="";

    public ReviewPage(){
        randomString=null;
    }


    public void selectPolicyDropdown(){
        WebElement policyDropdown = driver.findElement(getByLocator(projectProperty.walletHubORData,"ReviewPage","policydropdown"));
        policyDropdown.click();

        WebElement dropDownOption = waitForElementToBeClickable(projectProperty.walletHubORData,"ReviewPage","policyoption");
        dropDownOption.click();
    }

    public ConfirmationPage writeReview(){
        try {
            WebElement textArea = waitForElementToBeClickable(projectProperty.walletHubORData, "ReviewPage", "review");
            textArea.clear();
            randomString = JavaUtils.generateRandomString(200);
            textArea.sendKeys(randomString);
            Thread.sleep(2000);
            WebElement submitButton = waitForElementToBeClickable(projectProperty.walletHubORData, "ReviewPage", "submitbutton");
            clickElementUsingActionsClass(submitButton);
            return new ConfirmationPage();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}