package modelo;

import java.util.ArrayList;

import iu.VentanaPrincipal;

public class Xogo {
    private final int LADO_CADRADO = 30;
    private final int MAX_X = 300;
    private final int MAX_Y = 900;
    private boolean pausa;
    private int numeroLinas;
    private VentanaPrincipal ventanaPrincipal;
    private ArrayList<Cadrado> cadradosChan;
    private Ficha fichaActual;

    public Xogo (VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
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
    
//    private void xenerarNovaFicha(Arraylist<Cadrado> cadrado) {
//		FichaCadrada novoCadrado = new FichaCadrada(cadrado);
//		
//		
//    }
    
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
