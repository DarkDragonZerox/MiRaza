package cl.evilcorp.miraza.model;

import java.util.List;


public class BreedImg {
    private List<String> message;
    private String status;

    public BreedImg(List<String> message, String status) {
        this.message = message;
        this.status = status;

    }

    public List<String> getMessage() {
        return message;
    }

}