package chambre.api;

import com.cloudmersive.client.model.FaceWithLandmarks;

import javax.swing.*;
import java.awt.*;

public class FaceApiFrame extends JFrame {

    private final FaceRecognitionAPICall api = new FaceRecognitionAPICall();
    private FaceRecognitionView view = new FaceRecognitionView();

    private FaceWithLandmarks faceFromAPI;
    private Image picture;

    public FaceApiFrame() {
        JPanel panel = new JPanel(new BorderLayout());
        FaceRecognitionController controller = new FaceRecognitionController(api, view);


        JLabel textBox = new JLabel("Facial Feature Recognition");
        textBox.setPreferredSize(new Dimension(100, 100));
        textBox.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(textBox, BorderLayout.NORTH);

        picture = controller.updateImage();
        faceFromAPI = controller.updateFace();

        panel.add(view, BorderLayout.CENTER);

//       Panel to display the different landmarks
//       JPanel selectLandmark = new JPanel();
//        String [] facePoints = {"top", "bottom","left","right"};
//        JComboBox landmarkList = new JComboBox(facePoints);
//        selectLandmark.add(landmarkList,BorderLayout.NORTH);
//        panel.add(selectLandmark, BorderLayout.SOUTH);

        setTitle("Face Recognition API");
        setSize(500, 700);
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
