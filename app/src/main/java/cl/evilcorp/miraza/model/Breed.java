package cl.evilcorp.miraza.model;

import java.util.List;
import java.util.Map;

public class Breed {
    private Map<String, List<String>> message;
    private String status;

    public Breed(Map<String, List<String>> message, String status) {
        this.message = message;
        this.status = status;
    }

    public Map<String, List<String>> getMessage() {
        return message;
    }



    @Override
    public String toString() {
        return "Breed{" +
                "message=" + message +
                ", status='" + status + '\'' +
                '}';
    }
}
