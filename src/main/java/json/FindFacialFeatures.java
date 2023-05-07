
package json;

import java.util.List;

public class FindFacialFeatures {

    private String errorDetails;
    private String faceCount;
    private List<Face> faces;
    private String successful;

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public String getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(String faceCount) {
        this.faceCount = faceCount;
    }

    public List<Face> getFaces() {
        return faces;
    }

    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }

    public String getSuccessful() {
        return successful;
    }

    public void setSuccessful(String successful) {
        this.successful = successful;
    }

}
