package drivers;

import org.openqa.selenium.WebDriver;

public interface Driver {
    public WebDriver initDriver();
    public void end();
}
