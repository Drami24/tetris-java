package modelo;

import java.util.ArrayList;

public abstract class Ficha {
    private ArrayList<Cadrado> cadrados = new ArrayList<>();
    private Xogo xogo;

    public ArrayList<Cadrado> getCadrados() {
        return cadrados;
    }

    public void setCadrados(ArrayList<Cadrado> cadrados) {
        this.cadrados = cadrados;
    }

    public Xogo getXogo() {
        return xogo;
    }

    public boolean moverDereita() {
        for (Cadrado cadrado : cadrados) {
            cadrado.setX(cadrado.getX() + Xogo.LADO_CADRADO);
        }
        return true;
    }

    public boolean moverEsquerda() {
        for (Cadrado cadrado : cadrados) {
            cadrado.setX(cadrado.getX() - Xogo.LADO_CADRADO);
        }
        return true;
    }

    public boolean moverAbaixo() {
        for (Cadrado cadrado : cadrados) {
            cadrado.setY(cadrado.getY() + Xogo.LADO_CADRADO);
        }
        return false;
    }
    public abstract boolean rotar();

}