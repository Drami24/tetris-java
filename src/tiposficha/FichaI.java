package tiposficha;

import java.awt.Color;
import java.util.ArrayList;

import modelo.Cadrado;
import modelo.Ficha;
import modelo.Xogo;

public class FichaI extends Ficha {
    private Cadrado cadrado0;
    private Cadrado cadrado1;
    private Cadrado cadrado2;
    private Cadrado cadrado3;
    private boolean posicionRotacion = false;

    public FichaI() {
        super.setCadrados(xerarCadrados());
    }

    @Override
    public boolean rotar() {
        if (!posicionRotacion) {
            cadrado0.setX(cadrado0.getX() + Xogo.LADO_CADRADO * 2);
            cadrado0.setY(cadrado0.getY() - Xogo.LADO_CADRADO);
            cadrado1.setX(cadrado1.getX() + Xogo.LADO_CADRADO);
            cadrado2.setY(cadrado2.getY() + Xogo.LADO_CADRADO);
            cadrado3.setX(cadrado3.getX() - Xogo.LADO_CADRADO);
            cadrado3.setY(cadrado3.getY() + Xogo.LADO_CADRADO * 2);
            posicionRotacion = true;
        } else {
            cadrado0.setX(cadrado0.getX() - Xogo.LADO_CADRADO * 2);
            cadrado0.setY(cadrado0.getY() + Xogo.LADO_CADRADO);
            cadrado1.setX(cadrado1.getX() - Xogo.LADO_CADRADO);
            cadrado2.setY(cadrado2.getY() - Xogo.LADO_CADRADO);
            cadrado3.setX(cadrado3.getX() + Xogo.LADO_CADRADO);
            cadrado3.setY(cadrado3.getY() - Xogo.LADO_CADRADO * 2);
            posicionRotacion = false;
        }
        return false;
    }

    private ArrayList<Cadrado> xerarCadrados() {
        int ladoDereito = Xogo.MAX_X / 2;
        int ladoEsquerdo = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO;
        int ladoArriba = Xogo.LADO_CADRADO;
        ArrayList<Cadrado> cadrados = new ArrayList<>();
        cadrado0 = new Cadrado(ladoEsquerdo - Xogo.LADO_CADRADO, ladoArriba, Color.CYAN);
        cadrado1 = new Cadrado(ladoEsquerdo, ladoArriba, Color.CYAN);
        cadrado2 = new Cadrado(ladoDereito, ladoArriba, Color.CYAN);
        cadrado3 = new Cadrado(ladoDereito + Xogo.LADO_CADRADO, ladoArriba, Color.CYAN);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        return cadrados;
    }

}