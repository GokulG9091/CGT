package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory implements Driver {
    private WebDriver driver;

    @Override
    public WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "Driver/mac/chromedriver");
        this.driver = new ChromeDriver();
        return driver;
    }

    @Override
    public void end() {
        driver.quit();
    }
}
