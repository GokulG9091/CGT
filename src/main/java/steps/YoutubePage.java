package steps;

import java.util.List;

public interface YoutubePage{
   public void navigateToUrl(String url);
   public void searchForGivenTopic(String topicName);
   public void openChannel(String channelName);
   public void navigateToTab(String tabName);
    /**
     * will call the capture screen function
     * @param videoName
     */
    public void locateTheVideo(String videoName);
    public void clickAndChangeQuality(String videoQuality);
    List<String> getListOfUpcomingVideos();
}
