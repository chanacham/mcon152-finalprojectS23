package chambre.api;

import javax.swing.*;
import java.awt.*;

public class FaceApiFrame extends JFrame {
    public FaceApiFrame(){
        JPanel panel = new JPanel(new BorderLayout());

        JLabel textBox = new JLabel("Facial Feature Recognition");
        textBox.setPreferredSize(new Dimension(100,300));
        textBox.setFont(new Font("Arial",Font.BOLD,30));
        panel.add(textBox, BorderLayout.NORTH);

        JLabel recognition = new JLabel();
        recognition.setPreferredSize(new Dimension(100,300));
        panel.add(recognition, BorderLayout.SOUTH);

        setTitle("Face Recognition API");
        setSize(500, 700);
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
