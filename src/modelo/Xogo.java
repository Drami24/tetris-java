package modelo;

import java.util.ArrayList;

import iu.VentanaPrincipal;
import tiposficha.FichaCadrada;

import javax.swing.*;

public class Xogo {
    public final static int LADO_CADRADO = 30;
    public final static int MAX_X = 300;
    public final static int MAX_Y = 600;
    private boolean pausa;
    private int numeroLinas;
    private VentanaPrincipal ventanaPrincipal;
    private ArrayList<Cadrado> cadradosChan;
    private Ficha fichaActual;

    public Ficha getFichaActual() {
        return fichaActual;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public Xogo (VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        fichaActual = xenerarNovaFicha();
    }

    public void moverFichaDereita() {
        if(eMovementoValido(fichaActual.getCadrados(),LADO_CADRADO,0)) {
            fichaActual.moverDereita();
        }
    }
    
    public void moverFichaEsquerda() {
        if(eMovementoValido(fichaActual.getCadrados(), -LADO_CADRADO, 0)){
            fichaActual.moverEsquerda();
        }

    }
    
    public void moverFichaAbaixo() {
        if(eMovementoValido(fichaActual.getCadrados(),0, +LADO_CADRADO)){
            fichaActual.moverAbaixo();
        }
    }
    
    public void rotarFicha() {
    	fichaActual.rotar();
    }
    
    public Boolean ePosicionValida(int x, int y) {
    	if (x  >= MAX_X || x <0){
    	    return false;
        }else if (y >= MAX_Y || y < 0){
    	    return false;
        } else {
    	    return true;
        }
    }

    public Boolean ePosicionLimite(int x, int y) {
        if (x  == MAX_X - LADO_CADRADO || x==0){
            return true;
        }else if (y == MAX_Y - LADO_CADRADO){
            return true;
        } else {
            return false;
        }
    }
    
    private Ficha xenerarNovaFicha() {
		FichaCadrada fichaCadrado = new FichaCadrada();
		for (Cadrado cadrado : fichaCadrado.getCadrados()) {
		    ventanaPrincipal.pintarCadrado(cadrado.getLblCadrado());
        }
        return fichaCadrado;
    }
    
    private void engadirFichaAoChan() {
    	
    }
    
    private void borrarLinasCompletas() {
    	
    }
    
    private void borrarLina() {
    	
    }
    
    private boolean chocaFichaCoChan() {
    	return false;
    }

    private Boolean eMovementoValido(ArrayList<Cadrado> cadradosDeFicha, int movementoX, int movementoY) {
        for (Cadrado cadrado : cadradosDeFicha) {
            if (this.ePosicionLimite(cadrado.getX(), cadrado.getY())){
                if (ePosicionValida(cadrado.getX()+movementoX, cadrado.getY()+movementoY) && cadrado.getY() != MAX_Y - LADO_CADRADO){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
