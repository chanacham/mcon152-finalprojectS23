package chambre.api;

import com.cloudmersive.client.model.FaceWithLandmarks;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FaceRecognitionControllerTest {

    @Test
    void getFaceFromController() {
        //given
        FaceRecognitionAPICall api = new FaceRecognitionAPICall();
        FaceRecognitionView view = new FaceRecognitionView();
        FaceRecognitionController controller = new FaceRecognitionController(api, view);
        //when
        FaceWithLandmarks face = controller.getFaceFromController();
        //then
        assertNotNull(face);
    }

    @Test
    void getImageFromController() {
        //given
        FaceRecognitionAPICall api = new FaceRecognitionAPICall();
        FaceRecognitionView view = new FaceRecognitionView();
        FaceRecognitionController controller = new FaceRecognitionController(api, view);

        //when
        Image image = controller.getImageFromController();
        //then
        assertNotNull(image);
    }
}