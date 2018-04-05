package xogo;

import java.util.ArrayList;

public abstract class Ficha {
    private ArrayList<Cadrado> cadrados;
    private Xogo xogo;
    public abstract boolean moverDereita();
    public abstract boolean moverEsquerda();
    public abstract boolean moverAbaixo();
    public abstract boolean rotar();

    public void setCadrados(ArrayList<Cadrado> cadrados) {
        this.cadrados = cadrados;
    }
}
