package chambre.api;

import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;


public class FaceRecognitionAPICall {
    public FaceRecognitionAPICall() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
        Apikey.setApiKey("76d11169-037a-4450-ac29-9a9688a36133");
    }
}
