package tiposficha;

import java.awt.Color;
import java.util.ArrayList;

import modelo.Cadrado;
import modelo.Ficha;
import modelo.Xogo;

public class FichaI extends Ficha {
    private boolean rotacion = true;

    public FichaI() {
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
                    getCadrados().get(i).setY(cadrado0Y + Xogo.LADO_CADRADO * 2);
                } else if (i == 1) {
                    int cadrado1X = getCadrados().get(i).getX();
                    getCadrados().get(i).setX(cadrado1X + Xogo.LADO_CADRADO);
                    int cadrado1Y = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado1Y + Xogo.LADO_CADRADO);
                } else if (i == 3) {
                    int cadrado3X = getCadrados().get(i).getX();
                    getCadrados().get(i).setX(cadrado3X - Xogo.LADO_CADRADO);
                    int cadrado3Y = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado3Y - Xogo.LADO_CADRADO);
                }
            }
            rotacion = false;
        } else {
            for (int i = 0; i < getCadrados().size(); i++) {
                if (i == 0) {
                    int cadrado0X = getCadrados().get(i).getX();
                    getCadrados().get(i).setX(cadrado0X - Xogo.LADO_CADRADO * 2);
                    int cadrado0Y = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado0Y - Xogo.LADO_CADRADO * 2);
                } else if (i == 1) {
                    int cadrado1X = getCadrados().get(i).getX();
                    getCadrados().get(i).setX(cadrado1X - Xogo.LADO_CADRADO);
                    int cadrado1Y = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado1Y - Xogo.LADO_CADRADO);
                } else if (i == 3) {
                    int cadrado3X = getCadrados().get(i).getX();
                    getCadrados().get(i).setX(cadrado3X + Xogo.LADO_CADRADO);
                    int cadrado3Y = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado3Y + Xogo.LADO_CADRADO);
                }
            }
            rotacion = true;
        }
        return false;
    }

    private ArrayList<Cadrado> xerarCadrados() {
        int ladoDereito = Xogo.MAX_X / 2;
        int ladoEsquerdo = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO;
        int ladoArriba = Xogo.LADO_CADRADO;
        ArrayList<Cadrado> cadrados = new ArrayList<>();
        Cadrado cadrado0 = new Cadrado(ladoEsquerdo - Xogo.LADO_CADRADO, ladoArriba, Color.CYAN);
        Cadrado cadrado1 = new Cadrado(ladoEsquerdo, ladoArriba, Color.CYAN);
        Cadrado cadrado2 = new Cadrado(ladoDereito, ladoArriba, Color.CYAN);
        Cadrado cadrado3 = new Cadrado(ladoDereito + Xogo.LADO_CADRADO, ladoArriba, Color.CYAN);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        return cadrados;
    }
}
