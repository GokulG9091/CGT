package mobileWebStepsImpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import steps.HelperClass;
import steps.YoutubePage;

import java.util.ArrayList;
import java.util.List;

public class MobileYoutubePageImpl implements YoutubePage {
    WebDriver driver;

    public MobileYoutubePageImpl(HelperClass helperClass) {
        this.driver=helperClass.getWebDriver();
    }

    @Override
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    @Override
    public void searchForGivenTopic(String topicName) {
        driver.findElement(By.xpath("//*[@class=\"icon-button topbar-menu-button-avatar-button\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"searchbox-input title\"]")).sendKeys(topicName);
        driver.findElement(By.xpath("//*[@aria-label=\"Search YouTube\"]")).click();
    }

    @Override
    public void openChannel(String channelName) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("(//*[@href=\"/user/stepinforum\"])[1]")).click();
    }

    @Override
    public void navigateToTab(String tabName) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@href=\"/user/stepinforum/videos\"]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void locateTheVideo(String videoName) {
        List<WebElement> availableTitles = driver.findElements(By.xpath("//h4[@class=\"compact-media-item-headline\"]"));
        int size = availableTitles.size();
        for (int i=0;i<size;i++){
            String videoPresent = availableTitles.get(i).getAttribute("innerHTML");
            if(videoPresent.equals(videoName)){
                availableTitles.get(i).click();
                System.out.println("video found");
                }
                else {
                System.out.println("video not found");
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void clickAndChangeQuality(String videoQuality) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("(//button[@class=\"icon-button \"])[2]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[contains (text(),'Playback settings')]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element = driver.findElement(By.xpath("//*[contains (@id ,'player-quality-dropdown')]"));
        Select select = new Select(element);
        select.selectByVisibleText(videoQuality);
        driver.findElement(By.xpath("//div[contains (text(),'OK')]")).click();
    }

    @Override
    public List<String> getListOfUpcomingVideos() {
        List<WebElement> upnext = driver.findElements(By.xpath("//h4[@class=\"compact-media-item-headline\"]"));
        System.out.println("upcoming"+upnext.size());


        List <String> s = new ArrayList<String>();

        for(WebElement w: upnext)
        {
            System.out.println(w.getAttribute("innerHTML"));
            s.add(w.getAttribute("innerHTML"));
            System.out.println(s);
        }

        return s;
    }
}
