package chambre.api;

import com.cloudmersive.client.model.FaceWithLandmarks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FaceApiFrame extends JFrame {

    private FaceRecognitionView view = new FaceRecognitionView();

    private FaceWithLandmarks faceFromAPI;
    private Image picture;

    public FaceApiFrame() {
        JPanel panel = new JPanel(new BorderLayout());
        FaceRecognitionController controller = new FaceRecognitionController( view);

        JPanel topPanel = new JPanel();
        JLabel textBox = new JLabel("Facial Feature Recognition");
        topPanel.add(textBox);

        JButton imageChooser = new JButton("Select Image");
        imageChooser.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            int result = fileChooser.showOpenDialog(panel);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected File: " + selectedFile);
                controller.setImageFile(selectedFile);
                picture = controller.updateImage();
                faceFromAPI = controller.updateFace();
            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("File selection canceled, setting image to default file");
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
