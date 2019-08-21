package steps;

import drivers.Driver;
import drivers.DriverFactory;
import drivers.MobileDriver;
import org.openqa.selenium.WebDriver;

public class HelperClass {
    String platform;
    WebDriver webDriver;
    Driver driverClass;

    public HelperClass(String platform) {
        this.platform = platform;


        if (platform.equalsIgnoreCase("mobileWeb")){
            driverClass = new MobileDriver();
        }else {
            driverClass = new DriverFactory();
        }
        webDriver = driverClass.initDriver();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Driver getDriverClass() {
        return driverClass;
    }
}

