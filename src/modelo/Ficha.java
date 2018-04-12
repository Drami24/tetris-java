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
    
	public abstract boolean moverDereita();
    public abstract boolean moverEsquerda();
    public abstract boolean moverAbaixo();
    public abstract boolean rotar();

}