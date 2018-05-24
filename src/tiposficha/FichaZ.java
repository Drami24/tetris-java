package tiposficha;

import modelo.Cadrado;
import modelo.Ficha;
import modelo.Xogo;

import java.awt.*;
import java.util.ArrayList;

public class FichaZ extends Ficha {
    private boolean rotacion = true;

    public FichaZ() {
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
        if (rotacion) {
            for (int i = 0; i < getCadrados().size(); i++) {
                if (i == 0) {
                    int cadrado0X = getCadrados().get(i).getX();
                    getCadrados().get(i).setX(cadrado0X + Xogo.LADO_CADRADO * 2);
                    int cadrado0Y = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado0Y - Xogo.LADO_CADRADO);
                } else if (i == 3) {
                    int cadrado3X = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado3X - Xogo.LADO_CADRADO);
                }
            }
            rotacion = false;
        } else {
            for (int i = 0; i < getCadrados().size(); i++) {
                if (i == 0) {
                    int cadrado0X = getCadrados().get(i).getX();
                    getCadrados().get(i).setX(cadrado0X - Xogo.LADO_CADRADO * 2);
                    int cadrado0Y = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado0Y + Xogo.LADO_CADRADO);
                } else if (i == 3) {
                    int cadrado3X = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado3X + Xogo.LADO_CADRADO);
                }
            }
            rotacion = true;
        }
        return false;
    }

    private ArrayList<Cadrado> xerarCadrados() {
        int ladoDereito = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO;
        int ladoEsquerdo = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO *2;
        int ladoArriba = 0;
        int ladoAbaixo = Xogo.LADO_CADRADO;
        ArrayList<Cadrado> cadrados = new ArrayList<>();
        Cadrado cadrado0 = new Cadrado(ladoEsquerdo, ladoArriba, Color.RED);
        Cadrado cadrado1 = new Cadrado(ladoDereito, ladoArriba, Color.RED);
        Cadrado cadrado2 = new Cadrado(ladoDereito, ladoAbaixo, Color.RED);
        Cadrado cadrado3 = new Cadrado(ladoDereito + Xogo.LADO_CADRADO, ladoAbaixo, Color.RED);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        return cadrados;
    }
}
