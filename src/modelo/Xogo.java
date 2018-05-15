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
    private ArrayList<Cadrado> cadradosChan = new ArrayList<>();
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
        xenerarNovaFicha();
    }


    public void moverFichaDereita() {
        if(eMovementoValido(fichaActual.getCadrados(),LADO_CADRADO,0)) {
            fichaActual.moverDereita();
            comprobarMovementoFicha();
        }
    }
    
    public void moverFichaEsquerda() {
        if(eMovementoValido(fichaActual.getCadrados(), -LADO_CADRADO, 0)){
            fichaActual.moverEsquerda();
            comprobarMovementoFicha();
        }

    }
    
    public void moverFichaAbaixo() {
        if(eMovementoValido(fichaActual.getCadrados(),0, +LADO_CADRADO)){
            fichaActual.moverAbaixo();
            comprobarMovementoFicha();
        }
    }

    private void xerarFiguraFicticia(Cadrado movementoX, Cadrado movementoY) {
        Ficha fichaClon = fichaActual;

    }

    private void comprobarMovementoFicha(){
        if(chocaFichaCoChan(fichaActual)){
            System.out.println("A ficha chocou co chan");
            unirFichaOChan(fichaActual);
            xenerarNovaFicha();
        }
    }

    private void unirFichaOChan(Ficha fichaActual) {
        for (Cadrado cadrado : fichaActual.getCadrados()) {
            cadradosChan.add(cadrado);
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
        fichaActual = fichaCadrado;
        return fichaActual;
    }
    
    private void engadirFichaAoChan() {
    	
    }
    
    private void borrarLinasCompletas() {
    	
    }
    
    private void borrarLina() {
    	
    }
    
    private boolean chocaFichaCoChan(Ficha fichaActual) {
    	for(Cadrado cadrado : fichaActual.getCadrados()){
    	    if (cadradoTocaOChan(cadrado))
                 return true;
        }
        return false;
    }

    private boolean colisionaFigura(Cadrado cadrado) {
    	 for (Cadrado cadradoChan : cadradosChan) {
    	     boolean ladoIgualLimiteVertical = cadrado.getY() == cadradoChan.getY() - LADO_CADRADO;
    	     boolean ladoIgualLimiteHorizontalEsquerdo = cadrado.getX() == cadradoChan.getX() - LADO_CADRADO;
             boolean ladoIgualLimiteHorizontalDereito = cadrado.getX() == cadradoChan.getX() + LADO_CADRADO*2;
             if ( ladoIgualLimiteVertical && (ladoIgualLimiteHorizontalDereito || ladoIgualLimiteHorizontalEsquerdo)) {
            	 System.out.println("colision");
            	 return true;
             }
    		 
         }
    	 return false;
    }
    
    private boolean cadradoTocaOChan(Cadrado cadrado){
        boolean cadradoTocaSuelo = cadrado.getY() != MAX_Y - LADO_CADRADO;
        if( cadradoTocaSuelo && !colisionaFigura(cadrado) ){
            return false;
        } else {
            return true;
        }
    }

    private Boolean eMovementoValido(ArrayList<Cadrado> cadradosDeFicha, int movementoX, int movementoY) {
        for (Cadrado cadrado : cadradosDeFicha) {
            if (this.ePosicionLimite(cadrado.getX(), cadrado.getY())){
                if (!(ePosicionValida(cadrado.getX()+movementoX, cadrado.getY()+movementoY)) || cadradoTocaOChan(cadrado)){
                    return false;
                }
            }
        }
        return true;
    }
}
