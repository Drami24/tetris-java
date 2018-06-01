package tiposficha;

import modelo.Cadrado;
import modelo.Ficha;
import modelo.Xogo;

import java.awt.*;
import java.util.ArrayList;

public class FichaT extends Ficha {
    private Cadrado cadrado0;
    private Cadrado cadrado1;
    private Cadrado cadrado2;
    private Cadrado cadrado3;
    private int posicionRotacion = 0;

    public FichaT() {
        super.setCadrados(xerarCadrados());
    }

    @Override
    public boolean rotar() {
        if (posicionRotacion == 0) {
            cadrado0.setX(cadrado0.getX() + Xogo.LADO_CADRADO);
            cadrado0.setY(cadrado0.getY() - Xogo.LADO_CADRADO);
            cadrado2.setX(cadrado2.getX() - Xogo.LADO_CADRADO);
            cadrado2.setY(cadrado2.getY() + Xogo.LADO_CADRADO);
            cadrado3.setX(cadrado3.getX() - Xogo.LADO_CADRADO);
            cadrado3.setY(cadrado3.getY() - Xogo.LADO_CADRADO);
            posicionRotacion = 1;
        } else if (posicionRotacion == 1) {
            cadrado0.setX(cadrado0.getX() - Xogo.LADO_CADRADO);
            cadrado0.setY(cadrado0.getY() + Xogo.LADO_CADRADO * 2);
            cadrado1.setY(cadrado1.getY() + Xogo.LADO_CADRADO);
            cadrado2.setX(cadrado2.getX() + Xogo.LADO_CADRADO);
            cadrado3.setX(cadrado3.getX() + Xogo.LADO_CADRADO);
            posicionRotacion = 2;
        } else if (posicionRotacion == 2) {
            cadrado0.setX(cadrado0.getX() + Xogo.LADO_CADRADO);
            cadrado0.setY(cadrado0.getY() - Xogo.LADO_CADRADO * 2);
            cadrado1.setY(cadrado1.getY() - Xogo.LADO_CADRADO);
            cadrado2.setX(cadrado2.getX() - Xogo.LADO_CADRADO);
            cadrado3.setX(cadrado3.getX() + Xogo.LADO_CADRADO);
            posicionRotacion = 3;
        } else if (posicionRotacion == 3) {
            cadrado0.setX(cadrado0.getX() - Xogo.LADO_CADRADO);
            cadrado0.setY(cadrado0.getY() + Xogo.LADO_CADRADO);
            cadrado2.setX(cadrado2.getX() + Xogo.LADO_CADRADO);
            cadrado2.setY(cadrado2.getY() - Xogo.LADO_CADRADO);
            cadrado3.setX(cadrado3.getX() - Xogo.LADO_CADRADO);
            cadrado3.setY(cadrado3.getY() + Xogo.LADO_CADRADO);
            posicionRotacion = 0;
        }
        return false;
    }

    private ArrayList<Cadrado> xerarCadrados() {
        int ladoDereito = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO;
        int ladoEsquerdo = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO * 2;
        int ladoArriba = 0;
        int ladoAbaixo = Xogo.LADO_CADRADO;
        ArrayList<Cadrado> cadrados = new ArrayList<>();
        cadrado0 = new Cadrado(ladoEsquerdo, ladoArriba, Color.MAGENTA);
        cadrado1 = new Cadrado(ladoDereito, ladoArriba, Color.MAGENTA);
        cadrado2 = new Cadrado(ladoDereito + Xogo.LADO_CADRADO, ladoArriba, Color.MAGENTA);
        cadrado3 = new Cadrado(ladoDereito, ladoAbaixo, Color.MAGENTA);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        return cadrados;
    }

}