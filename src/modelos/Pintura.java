package modelos;

import java.util.stream.Collectors;

public class Pintura {
    private String cor;
    private String face;

    public Pintura(String cor, String face) {
        this.cor = cor;
        this.face = face;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


    @Override
    public String toString() {

        return  "\n Cor: " + cor +
                "\n Face:  " + face;

    }
}
