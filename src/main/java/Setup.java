import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import customRunnable.CustomRunnable;
import utilities.Utility;

public class Setup {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Properties testDataProperties = Utility.getProperties("testData/testData.properties");
        CustomRunnable customRunnableForWeb;
        CustomRunnable customRunnableForMobile;

        customRunnableForMobile = new CustomRunnable("web");
        customRunnableForWeb = new CustomRunnable("mobileWeb");
        String startTime = simpleDateFormat.format(new Date());

        customRunnableForMobile.setStarTime(startTime);
        customRunnableForWeb.setStarTime(startTime);

        Thread threadForWeb = new Thread(customRunnableForWeb);
        Thread threadForMobile = new Thread(customRunnableForMobile);

        threadForWeb.start();
        threadForMobile.start();

    }
}