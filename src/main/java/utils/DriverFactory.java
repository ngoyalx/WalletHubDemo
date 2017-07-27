package utils;

import common.ProjectProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        }else if(projectProperty.getPropertyFromglobalHashMap("browser").equalsIgnoreCase("firefox")){
            configureFirefox();
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static void configureChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        if(currentOperatingSystem.toLowerCase().contains("mac")){
            System.setProperty("webdriver.chrome.driver",projectProperty.chromeDriverPathMac);
        }else if(currentOperatingSystem.toLowerCase().contains("windows")){
            System.setProperty("webdriver.chrome.driver",projectProperty.chromeDriverPathWindows);
        }
        driver = new ChromeDriver(options);
    }

    private static void configureFirefox(){
        if(currentOperatingSystem.toLowerCase().contains("mac")) {
            System.setProperty("webdriver.gecko.driver", projectProperty.firefoxDriverPathMac);
        }else if(currentOperatingSystem.toLowerCase().contains("windows")) {
            System.setProperty("webdriver.gecko.driver", projectProperty.firefoxDriverPathWindows);
        }
        driver = new FirefoxDriver();
    }

    public static void closeBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }


}
