package chambre.api;

import com.cloudmersive.client.model.FaceWithLandmarks;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FaceApiFrame extends JFrame {

    private FaceRecognitionAPICall api = new FaceRecognitionAPICall();
     FaceWithLandmarks faceFromAPI;
     private Image picture;

    public FaceApiFrame() {
        JPanel panel = new JPanel(new BorderLayout());

        faceFromAPI =  api.getCurrentFace();
        try{
            File imageFile = new File("C:/Users/cbcha/Downloads/faceImage2.jpg");
            picture = ImageIO.read(imageFile);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        FaceRecognitionView view = new FaceRecognitionView();
        view.setFaceImage(picture);
        view.setCurrentFace(faceFromAPI);
        panel.add(view, BorderLayout.CENTER);

        JLabel textBox = new JLabel("Facial Feature Recognition");
        textBox.setPreferredSize(new Dimension(100, 100));
        textBox.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(textBox, BorderLayout.NORTH);

        setTitle("Face Recognition API");
        setSize(500, 700);
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
