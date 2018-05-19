package tiposficha;

import java.awt.Color;
import java.util.ArrayList;

import modelo.Cadrado;
import modelo.Ficha;
import modelo.Xogo;

public class FichaS extends Ficha {
	
	public FichaS() {
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
		// TODO Auto-generated method stub
		return false;
	}

	private ArrayList<Cadrado> xerarCadrados() {
		int ladoDereito = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO;
		int ladoEsquerdo = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO *2;
		int ladoArriba = 0;
		int ladoAbaixo = Xogo.LADO_CADRADO;
        ArrayList<Cadrado> cadrados = new ArrayList<>();
        Cadrado cadrado0 = new Cadrado(ladoEsquerdo, ladoAbaixo, Color.GREEN);
        Cadrado cadrado1 = new Cadrado(ladoDereito, ladoAbaixo, Color.GREEN);
        Cadrado cadrado2 = new Cadrado(ladoDereito, ladoArriba, Color.GREEN);
        Cadrado cadrado3 = new Cadrado(ladoDereito + Xogo.LADO_CADRADO, ladoArriba, Color.GREEN);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        return cadrados;
	}
}