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
        fichaActual.moverDereita();
    }
    
    public void moverFichaEsquerda() {
    	fichaActual.moverEsquerda();
    }
    
    public void moverFichaAbaixo() {
    	fichaActual.moverAbaixo();
    }
    
    public void rotarFicha() {
    	fichaActual.rotar();
    }
    
    public Boolean ePosicionValida(int x, int y) {
    	if (x  >= MAX_X || x<0){
    	    return false;
        }else if (y >= MAX_Y || y < 0){
    	    return false;
        } else {
    	    return true;
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
}
