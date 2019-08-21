package CustomRunnable;


import java.text.SimpleDateFormat;

public class CustomRunnable implements Runnable {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private PlatformFactory platformFactory;
    private String starTime;

    public CustomRunnable(String platform) {
        this.platformFactory = new PlatformFactory(platform);

    }

    @Override
    public void run() {
        executeSteps();
    }

    private void executeSteps() {


        platformFactory.tearDown();
//      platformFactory.helperClass.getReports().setEndTime(simpleDateFormat.format(new Date()));
//        platformFactory.writeReports();
    }

    public void setStarTime(String starTime) {
        //platformFactory.helperClass.getReports().setStartTime(starTime);
    }
}
