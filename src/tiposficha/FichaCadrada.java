package tiposficha;

import java.awt.*;

import modelo.Cadrado;
import modelo.Ficha;

public class FichaCadrada extends Ficha {

	public FichaCadrada() {
		Cadrado cadrado0 = new Cadrado(172, 11, Color.BLUE);
		Cadrado cadrado1 = new Cadrado(300, 100, Color.BLUE);
		Cadrado cadrado2 = new Cadrado(400, 200, Color.BLUE);
		Cadrado cadrado3 = new Cadrado(0, 0, Color.BLUE);
		getCadrados().add(cadrado0);
		getCadrados().add(cadrado1);
		getCadrados().add(cadrado2);
		getCadrados().add(cadrado3);
	}

	@Override
	public boolean moverDereita() {
		return false;
	}

	@Override
	public boolean moverEsquerda() {
		return false;
	}

	@Override
	public boolean moverAbaixo() {
		return false;
	}

	@Override
	public boolean rotar() {
		return false;
	}
}
