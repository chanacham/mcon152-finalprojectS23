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
    //API call is acting as a service to get the current face
    private FaceRecognitionAPICall api;

    public FaceRecognitionController(FaceRecognitionAPICall service,
                                     FaceRecognitionView view) {
        this.api = service;
        this.view = view;
    }

    public FaceWithLandmarks getFaceFromController() {
        FaceLocateWithLandmarksResponse response;
        FaceWithLandmarks face = null;
        FaceApi apiInstance = new FaceApi();
        File imageFile = new File("C:/Users/cbcha/Downloads/faceImage2.jpg");

        try {
            response = apiInstance.faceLocateWithLandmarks(imageFile);
            face = response.getFaces().get(0);
        } catch (ApiException e) {
            System.err.println("Exception when calling FaceApi#faceLocateWithLandmarks");
            e.printStackTrace();
        }
        return face;
    }

    public Image getImageFromController() {
        Image picture = null;
        try {
            File imageFile = new File("C:/Users/cbcha/Downloads/faceImage2.jpg");
            picture = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return picture;
    }

}
