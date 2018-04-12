package modelo;

import java.util.ArrayList;

import iu.VentanaPrincipal;
import tiposficha.FichaCadrada;

public class Xogo {
    public final static int LADO_CADRADO = 30;
    public final static int MAX_X = 300;
    public final static int MAX_Y = 900;
    private boolean pausa;
    private int numeroLinas;
    private VentanaPrincipal ventanaPrincipal;
    private ArrayList<Cadrado> cadradosChan;
    private Ficha fichaActual;

    public Xogo (VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        this.xenerarNovaFicha();
    }
    
    public void moverFichaDereita() {
    	// TODO
    }
    
    public void moverFichaEsquerda() {
    	// TODO
    }
    
    public void moverFichaAbaixo() {
    	// TODO
    }
    
    public void rotarFicha() {
    	
    }
    
    private void ePosicionValida(int x, int y) {
    	
    }
    
    private void xenerarNovaFicha() {
		FichaCadrada fichaCadrado = new FichaCadrada();
		for (Cadrado cadrado : fichaCadrado.getCadrados()) {
		    ventanaPrincipal.pintarCadrado(cadrado.getLblCadrado());
        }
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
