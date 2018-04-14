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

    public Xogo (VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        fichaActual = xenerarNovaFicha();
    }

    // FIXME: 14/04/2018 A ficha non se esta movendo a dereita
    public void moverFichaDereita() {
        for (Cadrado cadrado : fichaActual.getCadrados()){
            ventanaPrincipal.borrarCadrado(cadrado.getLblCadrado());
        }
        fichaActual.moverDereita();
        for (Cadrado cadrado : fichaActual.getCadrados()){
            ventanaPrincipal.pintarCadrado(cadrado.getLblCadrado());
        }
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
    
    private void ePosicionValida(int x, int y) {
    	
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
