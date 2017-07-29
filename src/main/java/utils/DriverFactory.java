package utils;

import common.ProjectProperty;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * Created by ngoyal on 25/07/17.
 */
public class DriverFactory {


    public static WebDriver driver;
    public static ProjectProperty projectProperty;
    static String currentOperatingSystem;

    public DriverFactory(){
        projectProperty = new ProjectProperty();
        currentOperatingSystem = System.getProperty("os.name");

    }

    public static WebDriver openBrowser(){
        if(projectProperty.getPropertyFromglobalHashMap("browser").equalsIgnoreCase("chrome")){
            configureChrome();
            driver.manage().window().setSize(maximizeChromeForMac());
        }else if(projectProperty.getPropertyFromglobalHashMap("browser").equalsIgnoreCase("firefox")){
            configureFirefox();
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static void configureChrome(){
        if(currentOperatingSystem.toLowerCase().contains("mac")){
            System.setProperty("webdriver.chrome.driver",projectProperty.chromeDriverPathMac);
        }else if(currentOperatingSystem.toLowerCase().contains("windows")){
            System.setProperty("webdriver.chrome.driver",projectProperty.chromeDriverPathWindows);
        }
        driver = new ChromeDriver();
    }

    private static void configureFirefox(){
        if(currentOperatingSystem.toLowerCase().contains("mac")) {
            System.setProperty("webdriver.gecko.driver", projectProperty.firefoxDriverPathMac);
        }else if(currentOperatingSystem.toLowerCase().contains("windows")) {
            System.setProperty("webdriver.gecko.driver", projectProperty.firefoxDriverPathWindows);
        }
        driver = new FirefoxDriver();
    }


    /**
     * Since chrome browser window is not maximized in Mac, following code will do it for you.
     * @return
     */
    private static Dimension maximizeChromeForMac(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String screenWidth = jse.executeScript("return screen.availWidth").toString();
        String screenHeight = jse.executeScript("return screen.availHeight").toString();
        int intScreenWidth = Integer.parseInt(screenWidth);
        int intScreenHeight = Integer.parseInt(screenHeight);
        return new Dimension(intScreenWidth,intScreenHeight);
    }

    public static void closeBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }


}
