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

    }


}
