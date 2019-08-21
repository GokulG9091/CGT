package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver implements Driver {

    String appiumServiceUrl;
    AppiumDriverLocalService appiumService;

    public AppiumDriverLocalService getAppiumService() {
        return appiumService;
    }

    private WebDriver webDriver = null;

    @Override
    public WebDriver initDriver() {



        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - " + appiumServiceUrl);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("devicePlatform", "Android");
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("deviceName", "Galaxy M20");
        capabilities.setCapability("browserName", "Chrome");

        try {
            webDriver = new AndroidDriver<>(new URL(appiumServiceUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webDriver;
    }

    public void end() {
        System.out.println("Stop appium service");
        webDriver.quit();
        appiumService.stop();
    }
}
