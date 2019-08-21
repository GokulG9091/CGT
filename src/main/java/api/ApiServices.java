package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.io.File;

public class ApiServices {

    public static Response createGetResponse(String pathURI) {
        Response response = null;
        try {

            response = RestAssured
                    .when().get(pathURI)
                    .then()
                    .extract().response();
        } catch (Exception e) {
//            logger.log(Level.INFO, "RestAssured response error found with '" + pathURI + "' API", e);
        }

        return response;
    }

    public static String getVideoName(String baseURL) {
        Response response = createGetResponse("http://54.169.34.162:5252/video");
        return response.asString();
    }

//    -------- Uploading Results in json format

    public static Response createPostUploadFileResponse(String pathURI, String fileURL) {
        Response response = null;
        try {
            response = RestAssured
                    .given()
                    .header("Content-Type", "multipart/form-data")
                    .multiPart("file", new File(fileURL))
                    .when().post(pathURI)
                    .then().extract().response();
        } catch (Exception e) {
//            logger.log(Level.INFO, "RestAssured response error found with '" + pathURI + "' API", e);
        }
        return response;
    }

    public static String uploadResults(String baseURL, String fileName) {
        Response response = createPostUploadFileResponse("http://54.169.34.162:5252/upload", "/Users/margipatel/Desktop/autoThon/Test Autothon/src/test/java/steps/results.json");
        return response.asString();
    }

    public static String getSavedResponse(String baseURL, String responseID) {
        Response response = createGetResponse("http://54.169.34.162:5252/result/" + responseID);
        return response.asString();
    }

    public static String validateResults(JSONObject actualObject, JSONObject expectedObject) {
        String difference = "Objects differed at key\n";

        if (actualObject.get("team").equals(expectedObject.get("team"))) {
            System.out.println("match");
        } else {
            difference += "[team]; expected:<[" + actualObject.get("team") + "]> but was:<[" + expectedObject.get("team") + "]>\n";
        }

        if (actualObject.get("video").equals(expectedObject.get("video"))) {
            System.out.println("match");
        } else {
            difference += "[video]; expected:<[" + actualObject.get("video") + "]> but was:<[" + expectedObject.get("video") + "]>\n";
        }

        if (actualObject.get("upcomming-video").equals(expectedObject.get("upcomming-video"))) {
            System.out.println("match");
        } else {
            difference += "[upcomming-video]; expected:<[" + actualObject.get("upcomming-video") + "]> but was:<[" + expectedObject.get("upcomming-video") + "]>\n";
        }

        return difference;
    }

    public static void main(String args[]) {

//        System.out.println("Video Name: " + VideoName.getVideoName());
//        String responseId = VideoName.getUploadingResultsID();
//        System.out.println("Response ID: " + responseId);
//        System.out.println("Saved Response: " + VideoName.getSavedResponse(responseId));
//
//        JSONParser jsonParser = new JSONParser();
//        JSONObject fileJsonObject = null, resultJsonObject = null;
//
//        try (FileReader reader = new FileReader("/Users/margipatel/Desktop/autoThon/Test Autothon/src/test/java/steps/results.json")) {
//
//            fileJsonObject = (JSONObject) jsonParser.parse(reader);
//            resultJsonObject = (JSONObject) jsonParser.parse(VideoName.getSavedResponse(responseId));
//
//            System.out.println(fileJsonObject);
//            System.out.println(resultJsonObject);
//            String diff = VideoName.validateResults(fileJsonObject, resultJsonObject);
//            System.out.println(diff);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
    }
}
