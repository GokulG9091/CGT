package customRunnable;


import mobileWebStepsImpl.MobileYoutubePageImpl;
import WebStepsImpl.WebYoutubePageImpl;
import steps.HelperClass;
import steps.YoutubePage;

public class PlatformFactory {

    HelperClass helperClass;
    private String platform;
    private YoutubePage youtubePage;

    public PlatformFactory(String platform) {
        this.platform = platform;
        //this.helperClass = new HelperClass(platform);
    }

    public String getPlatform() {
        return platform;
    }

    public YoutubePage getYoutubePage() {
        switch (platform) {
            case "web":
                youtubePage = new WebYoutubePageImpl(helperClass);
                break;
            case "mobileWeb":
                youtubePage = new MobileYoutubePageImpl(helperClass);
                break;
        }
        return youtubePage;
    }

    public HelperClass getHelperClass() {
        return helperClass;
    }

    public void tearDown() {
        helperClass.getDriverClass().end();
    }
}
