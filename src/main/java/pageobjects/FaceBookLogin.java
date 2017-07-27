package pageobjects;

import common.ProjectProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SeleniumHandles;

/**
 * Created by ngoyal on 25/07/17.
 */
public class FaceBookLogin extends SeleniumHandles {

    WebDriver driver;
    ProjectProperty projectProperty;

    public FaceBookLogin(){
        this.driver = SeleniumHandles.driver;
        this.projectProperty = SeleniumHandles.projectProperty;
    }


    public String Login(){
        openUrl(projectProperty.getPropertyFromglobalHashMap("faceBookUrl"));

        WebElement username = driver.findElement(getByLocator(projectProperty.faceBookORData,"Homepage","username"));
        username.sendKeys(projectProperty.getPropertyFromglobalHashMap("facebookUserName"));

        WebElement password = driver.findElement(getByLocator(projectProperty.faceBookORData,"Homepage","password"));
        password.sendKeys(projectProperty.getPropertyFromglobalHashMap("facebookPassword"));

        WebElement submitButton = driver.findElement(getByLocator(projectProperty.faceBookORData,"Homepage","loginbutton"));
        submitButton.click();

        return driver.getTitle();
    }

    public void postMessage(){
        System.out.println("<<<<<<<<<<<<-----------Hello World--------------->>>>>>>>>>>>>>>>");
    }




}
