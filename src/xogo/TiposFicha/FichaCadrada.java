package xogo.TiposFicha;

import xogo.Cadrado;
import xogo.Ficha;

import java.util.ArrayList;

public class FichaCadrada extends Ficha {

    public FichaCadrada(ArrayList<Cadrado> cadrados){
        super.setCadrados(cadrados);
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
