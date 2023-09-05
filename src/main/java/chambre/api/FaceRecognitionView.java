package chambre.api;

import com.cloudmersive.client.model.FacePoint;
import com.cloudmersive.client.model.FaceWithLandmarks;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FaceRecognitionView extends JComponent {
    private FaceWithLandmarks face;
    private Image image;

    @Override
    protected void paintComponent(Graphics g) {
        //paint component
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        if (face != null) {
            g.setColor(Color.GREEN);
            drawWidthAndHeight(g);
            List<FacePoint> leftEyebrow = face.getLeftEyebrow();
            drawFeature(leftEyebrow, g);

            List<FacePoint> rightEyebrow = face.getRightEyebrow();
            drawFeature(rightEyebrow,g);

            List<FacePoint> leftEye = face.getLeftEye();
            drawFeature(leftEye,g);

            List<FacePoint> rightEye = face.getRightEye();
            drawFeature(rightEye,g);

            List<FacePoint> bottomAndSidesOfFace = face.getBottomAndSidesOfFace();
            drawFeature(bottomAndSidesOfFace, g);

            List<FacePoint> noseBridge = face.getNoseBridge();
            drawFeature(noseBridge,g);

            List<FacePoint> noseBottom = face.getNoseBottom();
            drawFeature(noseBottom, g);

            List<FacePoint> lipsInnerOutline = face.getLipsInnerOutline();
            drawFeature(lipsInnerOutline, g);

            List<FacePoint> lipsOuterOutline = face.getLipsOuterOutline();
            drawFeature(lipsOuterOutline, g);

        } else {
            System.out.println("Face is null!!");
        }

    }

    private void drawFeature (List<FacePoint> feature, Graphics g){
        for (int i = 0; i < feature.size() - 2; i++) {
            //TODO: this is nuts. There should not be a list with an entire null entry.
           if (feature.get(i) != null){
                g.drawLine(feature.get(i).getX(), feature.get(i).getY(), feature.get(i + 1).getX(), feature.get(i + 1).getY());
           }
        }
    }
    private void drawWidthAndHeight(Graphics g) {
        int bottom = face.getBottomY();
        int top = face.getTopY();
        int right = face.getRightX();
        int left = face.getLeftX();
        int middleX = (left + right) / 2;
        int middleY = (top + bottom) / 2;
        g.drawLine(middleX, bottom, middleX, top);
        g.drawLine(right, middleY, left, middleY);
    }

    public void setCurrentFace(FaceWithLandmarks face) {
        this.face = face;
        repaint();
    }

    public void setFaceImage(Image input) {
        this.image = input;
    }

}
