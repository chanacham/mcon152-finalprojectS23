package chambre.api;

import com.cloudmersive.client.model.FaceWithLandmarks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FaceApiFrame extends JFrame {

    private final FaceRecognitionAPICall api = new FaceRecognitionAPICall();
    private FaceRecognitionView view = new FaceRecognitionView();

    private FaceWithLandmarks faceFromAPI;
    private Image picture;

    public FaceApiFrame() {
        JPanel panel = new JPanel(new BorderLayout());
        FaceRecognitionController controller = new FaceRecognitionController(api, view);

        JPanel topPanel = new JPanel();
        JLabel textBox = new JLabel("Facial Feature Recognition");
        topPanel.add(textBox);

        JButton imageChooser = new JButton("Select Image");
        imageChooser.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            File defaultFile = new File("C:/Users/cbcha/Downloads/faceImage2.jpg");

            fileChooser.setSelectedFile(defaultFile);
            int result = fileChooser.showOpenDialog(panel);
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected File: " + selectedFile);
                controller.setImageFile(selectedFile);
                picture = controller.updateImage();
                faceFromAPI = controller.updateFace();
            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("File selection canceled, setting image to default file");
                controller.setImageFile(defaultFile);
            }
        });
        topPanel.add(imageChooser);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(view, BorderLayout.CENTER);

        setTitle("Face Recognition API");
        setSize(500, 700);
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
