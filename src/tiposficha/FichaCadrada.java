package tiposficha;

import java.util.ArrayList;

import modelo.Cadrado;
import modelo.Ficha;

public class FichaCadrada extends Ficha {
	
	ArrayList<Cadrado> fichaCadrada = getCadrados();
	
	public ArrayList<Cadrado> getCadrados() {
		return super.getCadrados();
	}
	
    public FichaCadrada(ArrayList<Cadrado> cadrados){
        this.fichaCadrada = cadrados;
    }
    
    @Override
    public boolean moverDereita() {
        return false;
    }

    @Override
    public boolean moverEsquerda() {
        return false;
    }

    @Override
    public boolean moverAbaixo() {
        return false;
    }

    @Override
    public boolean rotar() {
        return false;
    }
}
