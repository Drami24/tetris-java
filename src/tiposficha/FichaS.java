package tiposficha;

import java.awt.Color;
import java.util.ArrayList;

import modelo.Cadrado;
import modelo.Ficha;
import modelo.Xogo;

public class FichaS extends Ficha {
    private Cadrado cadrado0;
    private Cadrado cadrado1;
    private Cadrado cadrado2;
    private Cadrado cadrado3;
    private boolean posicionRotacion = false;

    public FichaS() {
        super.setCadrados(xerarCadrados());
    }

    @Override
    public boolean rotar() {
        if (!posicionRotacion) {
            cadrado0.setY(cadrado0.getY() - Xogo.LADO_CADRADO * 2);
            cadrado1.setX(cadrado1.getX() - Xogo.LADO_CADRADO);
            cadrado1.setY(cadrado1.getY() - Xogo.LADO_CADRADO);
            cadrado3.setX(cadrado3.getX() - Xogo.LADO_CADRADO);
            cadrado3.setY(cadrado3.getY() + Xogo.LADO_CADRADO);
            posicionRotacion = true;
        } else {
            cadrado0.setY(cadrado0.getY() + Xogo.LADO_CADRADO * 2);
            cadrado1.setX(cadrado1.getX() + Xogo.LADO_CADRADO);
            cadrado1.setY(cadrado1.getY() + Xogo.LADO_CADRADO);
            cadrado3.setX(cadrado3.getX() + Xogo.LADO_CADRADO);
            cadrado3.setY(cadrado3.getY() - Xogo.LADO_CADRADO);
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
        cadrado0 = new Cadrado(ladoEsquerdo, ladoAbaixo, Color.GREEN);
        cadrado1 = new Cadrado(ladoDereito, ladoAbaixo, Color.GREEN);
        cadrado2 = new Cadrado(ladoDereito, ladoArriba, Color.GREEN);
        cadrado3 = new Cadrado(ladoDereito + Xogo.LADO_CADRADO, ladoArriba, Color.GREEN);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        return cadrados;
    }
}