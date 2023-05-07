package chambre.api;

import com.cloudmersive.client.ConvertDocumentApi;
import com.cloudmersive.client.FaceApi;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.cloudmersive.client.EditApi;
import com.cloudmersive.client.model.DrawTextRequest;
import com.cloudmersive.client.model.FaceLocateResponse;
import com.cloudmersive.client.model.FaceLocateWithLandmarksResponse;


import java.io.File;

public class CreateAPI {
    public CreateAPI() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("76d11169-037a-4450-ac29-9a9688a36133");
        Apikey.setApiKey("76d11169-037a-4450-ac29-9a9688a36133");

        convertDocumentToAPI();
        detectAndFindFaceInImage();
        drawOnImage();
    }

    private static void detectAndFindFaceInImage() {
        FaceApi apiInstance = new FaceApi();
        File imageFile = new File("C:/Users/cbcha/Downloads/faceImage.png"); // File | Image file to perform the operation on.  Common file formats such as PNG, JPEG are supported.
        try {
            FaceLocateResponse result = apiInstance.faceLocate(imageFile);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FaceApi#faceLocate");
            e.printStackTrace();
        }
        //this landmarks different feat
        try {
            FaceLocateWithLandmarksResponse result = apiInstance.faceLocateWithLandmarks(imageFile);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FaceApi#faceLocateWithLandmarks");
            e.printStackTrace();
        }
    }

    private static void drawOnImage() {
        EditApi apiInstance = new EditApi();
        DrawTextRequest request = new DrawTextRequest(); // DrawTextRequest | Draw text parameters
        try {
            byte[] result = apiInstance.editDrawText(request);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EditApi#editDrawText");
            e.printStackTrace();
        }
    }

    private static void convertDocumentToAPI() {
        ConvertDocumentApi apiInstance = new ConvertDocumentApi();
        File inputFile = new File("C:/Users/cbcha/Downloads/faceImage.png"); // File | Input file to perform the operation on.
        try {
            byte[] result = apiInstance.convertDocumentDocxToPdf(inputFile);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConvertDocumentApi#convertDocumentDocxToPdf");
            e.printStackTrace();
        }
    }

}
