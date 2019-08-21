package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utility {

    public static Properties getEnvironmentProperties() {
        Properties envProperties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("testData/environment.properties");
            envProperties.load(inputStream);
            System.out.println(envProperties.getProperty("fjbdfjb"));
        } catch (Exception e) {

        }
        return envProperties;
    }


}
