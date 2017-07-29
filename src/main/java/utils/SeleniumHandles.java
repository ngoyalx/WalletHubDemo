package utils;

import common.ProjectProperty;
import interfaces.SeleniumActions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by ngoyal on 23/07/17.
 */
public class SeleniumHandles extends DriverFactory implements SeleniumActions {

    public static WebDriver driver;
    private static WebDriverWait wait;
    private static String currentOperatingSystem;
    public static ProjectProperty projectProperty;

    public SeleniumHandles(){
        currentOperatingSystem = System.getProperty("os.name").toLowerCase();
        this.projectProperty = DriverFactory.projectProperty;
        this.driver = DriverFactory.driver;
        wait = new WebDriverWait(driver,20);
    }


    public void openUrl(String url) {
        driver.get(url);
    }

    public By getByLocator(String how, String locator){

        locator = locator.toLowerCase();

        switch (how) {
            case "xpath" :
                return By.xpath(locator);

            case "css" :
                return By.cssSelector(locator);

            case "linktext" :
                return By.linkText(locator);

            case "id" :
                return By.id(locator);

            case "name" :
                return By.name(locator);

            default:
                throw new IllegalArgumentException();
        }
    }


    public By getByLocator(List<String[]> ORData, String parent, String testobject){
        HashMap<String,String> elementDetails = getElementDetailsFromOR(ORData,parent,testobject);
        String how = elementDetails.get("how");
        String what = elementDetails.get("what");
        return getByLocator(how,what);
    }

    public WebElement waitForElementToBeVisible(List<String[]> ORData, String parent, String testobject){
        HashMap<String,String> elementDetails = getElementDetailsFromOR(ORData,parent,testobject);
        String how = elementDetails.get("how");
        String what = elementDetails.get("what");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(how,what)));
        return driver.findElement(getByLocator(how,what));
    }


    public WebElement waitForElementToBeClickable(List<String[]> ORData, String parent, String testobject){
        HashMap<String,String> elementDetails = getElementDetailsFromOR(ORData,parent,testobject);
        String how = elementDetails.get("how");
        String what = elementDetails.get("what");
        wait.until(ExpectedConditions.elementToBeClickable(getByLocator(how,what)));
        return driver.findElement(getByLocator(how,what));
    }


    public void waitAndclickObject(List<String[]> ORData, String parent, String testobject){
        HashMap<String,String> elementDetails = getElementDetailsFromOR(ORData,parent,testobject);
        String how = elementDetails.get("how");
        String what = elementDetails.get("what");
        wait.until(ExpectedConditions.elementToBeClickable(getByLocator(how,what)));
        driver.findElement(getByLocator(how,what)).click();
    }


    public void mouseHoverElement(List<String[]> ORData, String parent, String testobject){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(getByLocator(ORData,parent,testobject));
        action.moveToElement(element).build().perform();
    }

    public void mouseHoverElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void clickElementUsingActionsClass(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }

    public void moveToElementUsingActionsClass(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }

    public void sendKeysUsingActionsClass(WebElement element,String text){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
        action.sendKeys(element,text).build().perform();
    }

    public void clickElementUsingJavaScript(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();
    }

    public void clickElementBasedOnCordinates(){
        Actions action = new Actions(driver);
        action.moveByOffset(600, 350).click().build().perform();
    }

    public static void takescreenshot(String methodname){
        try{
            File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File desitation=new File((projectProperty.screenShotPath + methodname + ".png"));
            FileUtils.copyFile(screenshot, desitation);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public HashMap<String,String> getElementDetailsFromOR(List<String[]> ORData, String parent, String testobject){

        int totalRows = ORData.size();
        HashMap<String,String> objectDetails = new HashMap<>();
        try {
            for (int iterativeRow = 0; iterativeRow < totalRows; iterativeRow++) {
                if ((ReaderUtility.getCellValue(ORData, iterativeRow, "parent").equalsIgnoreCase(parent)
                        && (ReaderUtility.getCellValue(ORData, iterativeRow, "testobject").equalsIgnoreCase(testobject)))) {

                    String how = ReaderUtility.getCellValue(ORData, iterativeRow, "how");
                    String what = ReaderUtility.getCellValue(ORData, iterativeRow, "what");
                    objectDetails.put("parent", parent);
                    objectDetails.put("testobject", testobject);
                    objectDetails.put("how", how);
                    objectDetails.put("what", what);
                    break;
                }
            }
            return objectDetails;
        }catch (Exception e){
            throw e;
        }
    }


}
