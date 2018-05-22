package tiposficha;

import java.awt.Color;
import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.SourceTreeManager;

import modelo.Cadrado;
import modelo.Ficha;
import modelo.Xogo;

public class FichaI extends Ficha {
	private int ladoDereito = Xogo.MAX_X / 2;
	private int ladoEsquerdo = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO;
	private int ladoArriba = 0;
	private int ladoAbaixo = Xogo.LADO_CADRADO;
	byte posicion = 0;

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
		if (posicion == 0) {
			for (int i = 0; i < super.getCadrados().size(); i++) {
				if (i == 0) {
					int cadrado0 = super.getCadrados().get(i).getX();
					super.getCadrados().get(i).setX(cadrado0);
				} else if (i == 1) {
					super.getCadrados().get(i).setX(ladoDereito);
					super.getCadrados().get(i).setY(ladoAbaixo);
				} else if (i == 2) {
					super.getCadrados().get(i).setX(ladoDereito);
					super.getCadrados().get(i).setY(ladoAbaixo + Xogo.LADO_CADRADO);
				} else if (i == 3) {
					super.getCadrados().get(i).setX(ladoDereito);
					super.getCadrados().get(i).setY(ladoAbaixo + Xogo.LADO_CADRADO*2);
				}
			}
			posicion = 1;
		} else {
			for (int i = 0; i < super.getCadrados().size(); i++) {
				if (i == 0) {
					super.getCadrados().get(i).setX(ladoEsquerdo);
					super.getCadrados().get(i).setY(ladoArriba);
				} else if (i == 1) {
					super.getCadrados().get(i).setX(ladoDereito);
					super.getCadrados().get(i).setY(ladoArriba);
				} else if (i == 2) {
					super.getCadrados().get(i).setX(ladoDereito + Xogo.LADO_CADRADO);
					super.getCadrados().get(i).setY(ladoArriba);
				} else if (i == 3) {
					super.getCadrados().get(i).setX(ladoDereito + Xogo.LADO_CADRADO*2);
					super.getCadrados().get(i).setY(ladoArriba);
				}
			}
			posicion = 0;
		}
		return false;
	}
	
	

	private ArrayList<Cadrado> xerarCadrados() {
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
