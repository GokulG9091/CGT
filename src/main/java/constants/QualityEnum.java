package constants;

public enum QualityEnum {
    VIDEO_QUALITY_240P("240p"),
    VIDEO_QUALITY_360p("360p"),
    VIDEO_QUALITY_720p("720p");

    private String videoQuality;

    QualityEnum(String videoQuality) {
        this.videoQuality = videoQuality;
    }

    public String getVideoQuality() {
        return videoQuality;
    }
}