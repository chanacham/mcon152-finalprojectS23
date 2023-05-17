package chambre.api;

import com.cloudmersive.client.model.FaceWithLandmarks;

public class FaceRecognitionController {
    private FaceRecognitionView view;
    //API call is acting as a service to get the current face
    private FaceRecognitionAPICall service;

    public FaceRecognitionController(FaceRecognitionAPICall service,
                                     FaceRecognitionView view) {
        this.service = service;
        this.view = view;
    }

    public FaceWithLandmarks updateFace() {
        //What if the face is null- have to catch
//        FaceWithLandmarks faceToReturn;
//        if(service.getCurrentFace() != null){
//            faceToReturn = service.getCurrentFace();
//        }
//        return faceToReturn;
        return service.getCurrentFace();
    }
}
