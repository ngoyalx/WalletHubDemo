package utils;
import java.io.*;
import java.util.*;

/**
 * Created by ngoyal on 24/07/17.
 */
public class ReaderUtility {


    public static List<String[]> getCompleteRows(String FilePath) throws IOException {

        File inFile = new File(FilePath);
        List<String[]> completeData = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inFile));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            throw e1;
        }
        try {
            String csvRow = "";

            // Skip reading the header
            // reader.readLine();
            while ((csvRow = reader.readLine()) != null) {
                String[] csvRowAsArray = csvRow.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                for (int i = 0; i < csvRowAsArray.length; i++) {
                    csvRowAsArray[i] = csvRowAsArray[i].trim();
                    if (csvRowAsArray[i].startsWith("\"") && csvRowAsArray[i].endsWith("\"")) {
                        csvRowAsArray[i] = csvRowAsArray[i].substring(1, csvRowAsArray[i].length() - 1);
                        csvRowAsArray[i] = csvRowAsArray[i].trim();
                    }
                    if (csvRowAsArray[i].contains("\"\"")) {
                        csvRowAsArray[i] = csvRowAsArray[i].replaceAll("\"\"", "\"");
                    }
                }
                completeData.add(csvRowAsArray);
            }
        } catch (Exception e) {

        } finally {
            reader.close();
        }
        return completeData;
    }


    public static String getCellValue(List<String[]> fileData, int row, String columnHeader){
        try {
            int columnNumber = 0;
            String[] headers = fileData.get(0);

            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase(columnHeader)) {
                    columnNumber = i;
                    break;
                }
            }

            String[] requiredRow = fileData.get(row);
            return requiredRow[columnNumber];
        }catch (Exception e){
            throw e;
        }
    }

    public static Properties readConfigFileAndReturnPropertyObject(String filePath){
        try {
            File file = new File(filePath);
            FileInputStream inputStream = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(inputStream);
            return prop;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static HashMap<Object,Object> storePropertiesIntoHashMap(Properties prop){
        try {
            HashMap<Object, Object> map = new HashMap<>();
            for (final Map.Entry<Object, Object> entry : prop.entrySet()) {
                map.put((String) entry.getKey(), (String) entry.getValue());
            }
            return map;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
