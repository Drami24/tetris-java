package modelo;

import java.util.ArrayList;

import javax.swing.JLabel;

import com.sun.prism.paint.Color;

import iu.VentanaPrincipal;
import tiposficha.FichaCadrada;

public class Xogo {
    private final static int LADO_CADRADO = 30;
    private final static int MAX_X = 300;
    private final static int MAX_Y = 900;
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
		FichaCadrada cuadrado = new FichaCadrada();
		
		
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
