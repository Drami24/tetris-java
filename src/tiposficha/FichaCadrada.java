package tiposficha;

import java.awt.*;
import java.util.ArrayList;

import modelo.Cadrado;
import modelo.Ficha;
import modelo.Xogo;

public class FichaCadrada extends Ficha {

    public FichaCadrada() {
        super.setCadrados(xerarCadrados());
    }

    @Override
    public boolean moverDereita() {
        for (Cadrado cadrado : super.getCadrados()) {
            cadrado.setX(cadrado.getX() + Xogo.LADO_CADRADO);
        }
        return true;
    }

    @Override
    public boolean moverEsquerda() {
        for (Cadrado cadrado : super.getCadrados()) {
            cadrado.setX(cadrado.getX() - Xogo.LADO_CADRADO);
        }
        return true;
    }

    @Override
    public boolean moverAbaixo() {
        for (Cadrado cadrado : super.getCadrados()) {
            cadrado.setY(cadrado.getY() + Xogo.LADO_CADRADO);
        }
        return false;
    }

    @Override
    public boolean rotar() {
        return false;
    }

    private ArrayList<Cadrado> xerarCadrados() {
        ArrayList<Cadrado> cadrados = new ArrayList<>();
        Cadrado cadrado0 = new Cadrado(Xogo.MAX_X / 2, 0, Color.BLUE, getXogo());
        Cadrado cadrado1 = new Cadrado(Xogo.MAX_X / 2, Xogo.LADO_CADRADO, Color.BLUE, getXogo());
        Cadrado cadrado2 = new Cadrado(Xogo.MAX_X / 2 - Xogo.LADO_CADRADO, 0, Color.BLUE, getXogo());
        Cadrado cadrado3 = new Cadrado(Xogo.MAX_X / 2 - Xogo.LADO_CADRADO, Xogo.LADO_CADRADO, Color.BLUE, getXogo());
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        return cadrados;
    }
}
