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
        FaceRecognitionView view = mock();
        FaceRecognitionController controller = new FaceRecognitionController( view);
        File defaultFile = new File("src/test/resources/faceImage.jpg");
        controller.setImageFile(defaultFile);

        //when
        FaceWithLandmarks face = controller.updateFace();
        //then
        assertNotNull(face);
    }

    @Test
    void getImageFromController() {
        //given
        FaceRecognitionView view = mock();
        FaceRecognitionController controller = new FaceRecognitionController(view);
        File defaultFile = new File("src/test/resources/faceImage.jpg");
        controller.setImageFile(defaultFile);

        //when
        Image image = controller.updateImage();
        //then
        assertNotNull(image);
    }

}