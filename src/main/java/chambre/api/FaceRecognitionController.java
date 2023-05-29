package chambre.api;

import com.cloudmersive.client.FaceApi;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.model.FaceLocateWithLandmarksResponse;
import com.cloudmersive.client.model.FaceWithLandmarks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FaceRecognitionController {
    private FaceRecognitionView view;
   // TODO: professor said this is never called, check to make sure calling API correctly. Move FaceApi to new class?
    //  private FaceRecognitionAPICall api;
    private final File imageFile = new File("C:/Users/cbcha/Downloads/faceImage2.jpg");
    //use JFileChooser to select an image, and upload it to the service.

    public FaceRecognitionController(FaceRecognitionAPICall service,
                                     FaceRecognitionView view) {
        //this.api = service;
        this.view = view;
    }

    public FaceWithLandmarks updateFace() {
        FaceLocateWithLandmarksResponse response;
        FaceWithLandmarks face = null;
        FaceApi apiInstance = new FaceApi();
        try {
            response = apiInstance.faceLocateWithLandmarks(imageFile);
            //NOTE: handle multiple faces??
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
