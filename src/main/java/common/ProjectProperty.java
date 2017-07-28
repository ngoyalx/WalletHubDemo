package common;

import utils.ReaderUtility;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ngoyal on 23/07/17.
 * This class will have all the project level variables and objects that will values
 * which will be used across project
 */
public class ProjectProperty {

    private static String fileSeparator;
    private static String currentWorkingDirectory;
    private static String configFilePath;
    public static String chromeDriverPathWindows;
    public static String chromeDriverPathMac;
    public static String firefoxDriverPathMac;
    public static String firefoxDriverPathWindows;
    public static String faceBookOR;
    public static String wallethubOR;
    public static List<String[]> faceBookORData;
    public static List<String[]> walletHubORData;
    public static ReaderUtility readerUtility;
    public static HashMap<Object,Object> globalProperties;




    public ProjectProperty(){
    fileSeparator = System.getProperty("file.separator");
    currentWorkingDirectory = System.getProperty("user.dir");
    chromeDriverPathWindows = currentWorkingDirectory + fileSeparator + "src" + fileSeparator + "main" + fileSeparator
            + "resources" + fileSeparator + "drivers" + fileSeparator + "chromedriver.exe";
    chromeDriverPathMac = currentWorkingDirectory + fileSeparator + "src" + fileSeparator + "main" + fileSeparator
            + "resources" + fileSeparator + "drivers" + fileSeparator + "chromedriver";
    firefoxDriverPathWindows = currentWorkingDirectory + fileSeparator + "src" + fileSeparator + "main" + fileSeparator
                + "resources" + fileSeparator + "drivers" + fileSeparator + "geckodriver.exe";
    firefoxDriverPathMac = currentWorkingDirectory + fileSeparator + "src" + fileSeparator + "main" + fileSeparator
                + "resources" + fileSeparator + "drivers" + fileSeparator + "geckodriver";
    faceBookOR = currentWorkingDirectory + fileSeparator + "src" + fileSeparator + "main" + fileSeparator
            + "resources" + fileSeparator + "objectRepository" + fileSeparator + "facebookOR.csv";
    wallethubOR = currentWorkingDirectory + fileSeparator + "src" + fileSeparator + "main" + fileSeparator
            + "resources" + fileSeparator + "objectRepository" + fileSeparator + "wallethubOR.csv";
    configFilePath = currentWorkingDirectory + fileSeparator + "config.properties";
    globalProperties = new HashMap<>();
    readAndStoreORData();
    loadConfigAndSystemPropertiesIntoHashMap();
    }

    private void readAndStoreORData(){
        try {
            faceBookORData = ReaderUtility.getCompleteRows(faceBookOR);
            walletHubORData = ReaderUtility.getCompleteRows(wallethubOR);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadConfigAndSystemPropertiesIntoHashMap(){
        globalProperties = ReaderUtility.storePropertiesIntoHashMap(ReaderUtility.readConfigFileAndReturnPropertyObject(configFilePath));
        //globalProperties = ReaderUtility.storePropertiesIntoHashMap(System.getProperties());
    }

    public String getPropertyFromglobalHashMap(String key){
        return globalProperties.get(key).toString();
    }


















}
