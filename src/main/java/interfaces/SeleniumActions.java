package interfaces;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ngoyal on 23/07/17.
 */
public interface SeleniumActions {

    void openUrl(String url);
    void waitAndclickObject(List<String[]> ORData,String parent,String testobject);
    WebElement waitForElementToBeVisible(List<String[]> ORData, String parent, String testobject);
    WebElement waitForElementToBeClickable(List<String[]> ORData,String parent,String testobject);
    By getByLocator(String how, String locator);
    By getByLocator(List<String[]> ORData, String parent, String testobject);
    HashMap<String,String> getElementDetailsFromOR(List<String[]> ORData, String parent, String testobject);
}
