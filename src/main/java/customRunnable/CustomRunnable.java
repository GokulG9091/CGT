package customRunnable;


import api.ApiServices;
import steps.YoutubePage;
import utilities.Utility;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class CustomRunnable implements Runnable {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private PlatformFactory platformFactory;
    private String starTime;
    YoutubePage youtubePage;
    Map<String, String> testDataPropertis;

    public CustomRunnable(String platform) {
        this.platformFactory = new PlatformFactory(platform);
        //this.testDataPropertis = testDataPropertis;
    }

    @Override
    public void run() {
        executeSteps();
    }

    private void executeSteps() {
        String baseURL = testDataPropertis.get("apiBaseUrl");
        youtubePage = platformFactory.getYoutubePage();
        youtubePage.navigateToUrl(testDataPropertis.get("url"));
        youtubePage.searchForGivenTopic(testDataPropertis.get("searchKey"));
        youtubePage.openChannel("channelName");
        youtubePage.navigateToTab("tabName");
        String videoName = ApiServices.getVideoName(baseURL);
        youtubePage.locateTheVideo(videoName);
        youtubePage.clickAndChangeQuality(testDataPropertis.get("videoQuality"));
        List<String> upcomingVideoList = youtubePage.getListOfUpcomingVideos();
        String fileName = Utility.writeIntoJsonFile(videoName, upcomingVideoList, testDataPropertis.get("teamName"));
        String responseID = ApiServices.uploadResults(baseURL,fileName);
        ApiServices.getSavedResponse(baseURL, responseID);
        platformFactory.tearDown();
//      platformFactory.helperClass.getReports().setEndTime(simpleDateFormat.format(new Date()));
//        platformFactory.writeReports();
    }

    public void setStarTime(String starTime) {
        //platformFactory.helperClass.getReports().setStartTime(starTime);
    }
}
