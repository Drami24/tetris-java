package tiposficha;

import java.awt.*;
import java.util.ArrayList;

import modelo.Cadrado;
import modelo.Ficha;

public class FichaCadrada extends Ficha {

	public FichaCadrada() {
		super.setCadrados(xerarCadrados());
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

	private ArrayList<Cadrado> xerarCadrados(){
		Cadrado cadrado0 = new Cadrado(172, 11, Color.BLUE);
		Cadrado cadrado1 = new Cadrado(300, 100, Color.BLUE);
		Cadrado cadrado2 = new Cadrado(400, 200, Color.BLUE);
		Cadrado cadrado3 = new Cadrado(0, 0, Color.BLUE);
		ArrayList<Cadrado> cadrados = new ArrayList<>();
		cadrados.add(cadrado0);
		cadrados.add(cadrado1);
		cadrados.add(cadrado2);
		cadrados.add(cadrado3);
		return cadrados;
	}
}
