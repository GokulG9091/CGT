package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Utility {

    public static Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(fileName);
            properties.load(inputStream);
            System.out.println(properties.getProperty("url"));
        } catch (Exception e) {

        }
        return properties;
    }
    public static String writeIntoJsonFile(String videoName, List<String> upcomingVideos, String teamName){
        return "fileName";
    }


}
