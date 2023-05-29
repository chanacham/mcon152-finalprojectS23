package chambre.api;

import com.cloudmersive.client.model.FaceWithLandmarks;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FaceRecognitionControllerTest {

    @Test
    void getFaceFromController() {
        //given
        FaceRecognitionAPICall api = new FaceRecognitionAPICall();
        FaceRecognitionView view = new FaceRecognitionView();
        FaceRecognitionController controller = new FaceRecognitionController(api, view);
        File defaultFile = new File("C:/Users/cbcha/Downloads/faceImage2.jpg");
        controller.setImageFile(defaultFile);

        //when
        FaceWithLandmarks face = controller.updateFace();
        //then
        assertNotNull(face);
    }

    @Test
    void getImageFromController() {
        //given
        FaceRecognitionAPICall api = new FaceRecognitionAPICall();
        FaceRecognitionView view = new FaceRecognitionView();
        FaceRecognitionController controller = new FaceRecognitionController(api, view);
        File defaultFile = new File("C:/Users/cbcha/Downloads/faceImage2.jpg");
        controller.setImageFile(defaultFile);

        //when
        Image image = controller.updateImage();
        //then
        assertNotNull(image);
    }

}