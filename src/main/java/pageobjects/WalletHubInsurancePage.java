package pageobjects;

import org.openqa.selenium.WebElement;
import utils.SeleniumHandles;

/**
 * Created by ngoyal on 26/07/17.
 */
public class WalletHubInsurancePage extends SeleniumHandles {


    public void gotoTestInsuranceCompanyPage(){
        openUrl(projectProperty.getPropertyFromglobalHashMap("walletHubUrl"));
    }

    public void login(){
        WebElement loginMenu = waitForElementToBeVisible(projectProperty.walletHubORData,"InsurancePage","loginmenu");
        loginMenu.click();

        WebElement username = waitForElementToBeVisible(projectProperty.walletHubORData,"InsurancePage","username");
        username.sendKeys(projectProperty.getPropertyFromglobalHashMap("wallethubUserName"));

        WebElement password = waitForElementToBeVisible(projectProperty.walletHubORData,"InsurancePage","password");
        password.sendKeys(projectProperty.getPropertyFromglobalHashMap("wallethubPassword"));

        WebElement loginButton = waitForElementToBeClickable(projectProperty.walletHubORData,"InsurancePage","loginbutton");
        loginButton.click();
    }

    public ReviewPage giveStarRating(){
        WebElement starating = waitForElementToBeVisible(projectProperty.walletHubORData,"InsurancePage","starating");
        mouseHoverElement(starating);

        WebElement changeRating = waitForElementToBeVisible(projectProperty.walletHubORData,"InsurancePage","changerating");
        changeRating.click();
        return new ReviewPage();
    }









}
