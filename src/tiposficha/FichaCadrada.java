package tiposficha;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

import modelo.Cadrado;
import modelo.Ficha;

public class FichaCadrada extends Ficha {

	public FichaCadrada() {
		JLabel lblCadrado = new JLabel("");
		Cadrado cadrado0 = new Cadrado(30, 870, Color.BLUE, lblCadrado);
		Cadrado cadrado1 = new Cadrado(30, 840, Color.BLUE, lblCadrado);
		Cadrado cadrado2 = new Cadrado(60, 870, Color.BLUE, lblCadrado);
		Cadrado cadrado3 = new Cadrado(60, 840, Color.BLUE, lblCadrado);
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
