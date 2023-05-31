package chambre.api;

import com.cloudmersive.client.FaceApi;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.cloudmersive.client.model.FaceLocateWithLandmarksResponse;
import com.cloudmersive.client.model.FaceWithLandmarks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FaceRecognitionController {
    private FaceRecognitionView view;
    private File imageFile;

    public FaceRecognitionController(FaceRecognitionView view) {
        this.view = view;

        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
        Apikey.setApiKey("76d11169-037a-4450-ac29-9a9688a36133");
    }

    public void setImageFile(File input) {
        this.imageFile = input;
    }

    public FaceWithLandmarks updateFace() {
        FaceLocateWithLandmarksResponse response;
        FaceWithLandmarks face = null;
        FaceApi apiInstance = new FaceApi();
        try {
            response = apiInstance.faceLocateWithLandmarks(imageFile);
            face = response.getFaces().get(0);
            view.setCurrentFace(face);
        } catch (ApiException e) {
            System.err.println("Exception when calling FaceApi#faceLocateWithLandmarks");
            e.printStackTrace();
        }
        return face;
    }

    public Image updateImage() {
        Image picture = null;
        try {
            picture = ImageIO.read(imageFile);
            view.setFaceImage(picture);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picture;
    }

}
