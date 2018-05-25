package tiposficha;

import java.awt.Color;
import java.util.ArrayList;

import modelo.Cadrado;
import modelo.Ficha;
import modelo.Xogo;

public class FichaL extends Ficha {
	private int rotacion = 0;

	public FichaL() {
		super.setCadrados(xerarCadrados());;
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
		if (rotacion == 0) {
            for (int i = 0; i < getCadrados().size(); i++) {
                if (i == 0) {
                    int cadradoY = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadradoY - Xogo.LADO_CADRADO*2);
                } else if (i==1) {
                	int cadradoX = getCadrados().get(i).getX();
                	getCadrados().get(i).setX(cadradoX + Xogo.LADO_CADRADO);
                	int cadradoY = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadradoY - Xogo.LADO_CADRADO);
                } else if (i==3) {
                	int cadradoX = getCadrados().get(i).getX();
                	getCadrados().get(i).setX(cadradoX - Xogo.LADO_CADRADO);
                	int cadradoY = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadradoY + Xogo.LADO_CADRADO);
                }
            }
            rotacion = 1;
        } else if (rotacion == 1) {
            for (int i = 0; i < getCadrados().size(); i++) {
                if (i == 0) {
                	int cadradoY = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadradoY + Xogo.LADO_CADRADO*2);
                } else if (i == 1) {
                	int cadradoY = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadradoY + Xogo.LADO_CADRADO*2);
                } else if (i ==2) {
                	int cadradoX = getCadrados().get(i).getX();
                	getCadrados().get(i).setX(cadradoX + Xogo.LADO_CADRADO);
                	int cadradoY = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadradoY + Xogo.LADO_CADRADO);
                } else if (i==3) {
                	int cadradoX = getCadrados().get(i).getX();
                	getCadrados().get(i).setX(cadradoX + Xogo.LADO_CADRADO);
                	int cadradoY = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadradoY - Xogo.LADO_CADRADO);
                }
            }
            rotacion = 2;
        } else if (rotacion == 2) {
            for (int i = 0; i < getCadrados().size(); i++) {
            	if (i == 0) {
            		int cadradoX = getCadrados().get(i).getX();
                	getCadrados().get(i).setX(cadradoX + Xogo.LADO_CADRADO);
                	int cadradoY = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadradoY - Xogo.LADO_CADRADO*2);
                } else if (i==3) {
                	int cadradoX = getCadrados().get(i).getX();
                    getCadrados().get(i).setX(cadradoX - Xogo.LADO_CADRADO);
                }
            }
            rotacion = 3;
        } else if (rotacion == 3) {
            for (int i = 0; i < getCadrados().size(); i++) {
                if (i == 0) {
                    int cadrado3X = getCadrados().get(i).getX();
                    getCadrados().get(i).setX(cadrado3X - Xogo.LADO_CADRADO);
                    int cadrado3Y = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado3Y + Xogo.LADO_CADRADO);
                } else if (i == 1) {
                	int cadrado3X = getCadrados().get(i).getX();
                    getCadrados().get(i).setX(cadrado3X - Xogo.LADO_CADRADO);
                } else if (i == 2) {
                	int cadrado3Y = getCadrados().get(i).getY();
                    getCadrados().get(i).setY(cadrado3Y - Xogo.LADO_CADRADO);
                }
            }
            rotacion = 0;
        }
        return false;
	}
	
	private ArrayList<Cadrado> xerarCadrados() {
		int ladoDereito = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO;
		int ladoEsquerdo = Xogo.MAX_X / 2 - Xogo.LADO_CADRADO *2;
		int ladoArriba = 0;
		int ladoAbaixo = Xogo.LADO_CADRADO;
        ArrayList<Cadrado> cadrados = new ArrayList<>();
        Cadrado cadrado0 = new Cadrado(ladoEsquerdo, ladoAbaixo, new Color(255,140,0));
        Cadrado cadrado1 = new Cadrado(ladoEsquerdo, ladoArriba, new Color(255,140,0));
        Cadrado cadrado2 = new Cadrado(ladoDereito, ladoArriba, new Color(255,140,0));
        Cadrado cadrado3 = new Cadrado(ladoDereito + Xogo.LADO_CADRADO, ladoArriba, new Color(255,140,0));
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        return cadrados;
    }

}
