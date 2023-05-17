package chambre.api;

import com.cloudmersive.client.model.FaceWithLandmarks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FaceRecognitionAPICallTest {
    @Test
    void getCurrentFace() {

        //give
        FaceRecognitionAPICall api = mock();

        //when
        FaceWithLandmarks face = api.getCurrentFace();

        //then
        assertNotNull(face.getBottomAndSidesOfFace());

    }

}