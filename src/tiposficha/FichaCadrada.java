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
    public ArrayList<Cadrado> obterFantasmaRotacion(int numeroRotacion) {
        Cadrado cadradoFantasma0 = copiarCadrado(super.getCadrados().get(0));
        Cadrado cadradoFantasma1 = copiarCadrado(super.getCadrados().get(1));
        Cadrado cadradoFantasma2 = copiarCadrado(super.getCadrados().get(2));
        Cadrado cadradoFantasma3 = copiarCadrado(super.getCadrados().get(3));

        return crearFantasma(cadradoFantasma0, cadradoFantasma1, cadradoFantasma2, cadradoFantasma3);
    }

    private ArrayList<Cadrado> xerarCadrados() {
        int ladoDereito = Xogo.MAX_X / 2;
        int ladoEsquerdo = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO;
        int ladoArriba = 0;
        int ladoAbaixo = Xogo.LADO_CADRADO;
        ArrayList<Cadrado> cadrados = new ArrayList<>();
        Cadrado cadrado0 = new Cadrado(ladoEsquerdo, ladoArriba, Color.YELLOW);
        Cadrado cadrado1 = new Cadrado(ladoDereito, ladoArriba, Color.YELLOW);
        Cadrado cadrado2 = new Cadrado(ladoEsquerdo, ladoAbaixo, Color.YELLOW);
        Cadrado cadrado3 = new Cadrado(ladoDereito, ladoAbaixo, Color.YELLOW);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        return cadrados;
    }

}