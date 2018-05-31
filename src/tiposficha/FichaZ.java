package tiposficha;

import modelo.Cadrado;
import modelo.Ficha;
import modelo.Xogo;

import java.awt.*;
import java.util.ArrayList;

public class FichaZ extends Ficha {
    private Cadrado cadrado0;
    private Cadrado cadrado1;
    private Cadrado cadrado2;
    private Cadrado cadrado3;
    private boolean posicionRotacion = false;

    public FichaZ() {
        super.setCadrados(xerarCadrados());
    }

    @Override
    public boolean rotar() {
        if (!posicionRotacion) {
            cadrado0.setX(cadrado0.getX() + Xogo.LADO_CADRADO);
            cadrado0.setY(cadrado0.getY() + Xogo.LADO_CADRADO);
            cadrado2.setX(cadrado2.getX() + Xogo.LADO_CADRADO);
            cadrado2.setY(cadrado2.getY() - Xogo.LADO_CADRADO);
            cadrado3.setY(cadrado3.getY() - Xogo.LADO_CADRADO * 2);
            posicionRotacion = true;
        } else {
            cadrado0.setX(cadrado0.getX() - Xogo.LADO_CADRADO);
            cadrado0.setY(cadrado0.getY() - Xogo.LADO_CADRADO);
            cadrado2.setX(cadrado2.getX() - Xogo.LADO_CADRADO);
            cadrado2.setY(cadrado2.getY() + Xogo.LADO_CADRADO);
            cadrado3.setY(cadrado3.getY() + Xogo.LADO_CADRADO * 2);
            posicionRotacion = false;
        }
        return false;
    }

    private ArrayList<Cadrado> xerarCadrados() {
        int ladoDereito = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO;
        int ladoEsquerdo = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO * 2;
        int ladoArriba = 0;
        int ladoAbaixo = Xogo.LADO_CADRADO;
        ArrayList<Cadrado> cadrados = new ArrayList<>();
        cadrado0 = new Cadrado(ladoEsquerdo, ladoArriba, Color.RED);
        cadrado1 = new Cadrado(ladoDereito, ladoArriba, Color.RED);
        cadrado2 = new Cadrado(ladoDereito, ladoAbaixo, Color.RED);
        cadrado3 = new Cadrado(ladoDereito + Xogo.LADO_CADRADO, ladoAbaixo, Color.RED);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        return cadrados;
    }

}