package chambre.api;

import com.cloudmersive.client.FaceApi;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.cloudmersive.client.model.FaceLocateWithLandmarksResponse;
import com.cloudmersive.client.model.FaceWithLandmarks;



import java.io.File;

public class FaceRecognitionAPICall {
    //this class acts as the service: gets the current Face object
    private FaceLocateWithLandmarksResponse response;
    private FaceWithLandmarks face;
    public FaceRecognitionAPICall() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
        Apikey.setApiKey("76d11169-037a-4450-ac29-9a9688a36133");

        FaceApi apiInstance = new FaceApi();
        File imageFile = new File("C:/Users/cbcha/Downloads/faceImage2.jpg");

        try {
            response = apiInstance.faceLocateWithLandmarks(imageFile);
            face  = response.getFaces().get(0);
        } catch (ApiException e) {
            System.err.println("Exception when calling FaceApi#faceLocateWithLandmarks");
            e.printStackTrace();
        }
    }
    public FaceWithLandmarks getCurrentFace(){
        return face;
    }

    public FaceLocateWithLandmarksResponse getResponse() {
        return response;
    }


}
