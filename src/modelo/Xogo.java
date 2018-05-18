package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import iu.VentanaPrincipal;
import tiposficha.*;

import javax.swing.*;

public class Xogo {
    public final static int LADO_CADRADO = 30;
    public final static int MAX_X = 300;
    public final static int MAX_Y = 600;
    private int FICHA_CADRADA = 0;

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
        int movementoY = 0;
        int movementoX = LADO_CADRADO;
        if(fichaEPosicionValida(xerarCadradosFantasma(movementoX,movementoY), movementoY)){
            fichaActual.moverDereita();
        }
    }
    
    public void moverFichaEsquerda() {
        int movementoY = 0;
        int movementoX = -LADO_CADRADO;
        if(fichaEPosicionValida(xerarCadradosFantasma(movementoX,movementoY),movementoY)){
            fichaActual.moverEsquerda();
        }
    }
    
    public void moverFichaAbaixo() {
        int movementoY = LADO_CADRADO;
        int movementoX = 0;
        ArrayList<Cadrado> cadradosFantasma = xerarCadradosFantasma(movementoX,movementoY);
        if(fichaEPosicionValida(cadradosFantasma,movementoY)){
            fichaActual.moverAbaixo();
        }
    }

    public void rotarFicha() {
        fichaActual.rotar();
    }

    private ArrayList<Cadrado> xerarCadradosFantasma(int movementoX, int movementoY) {
        ArrayList <Cadrado> cadradosFantasma = new ArrayList<>();
        for (Cadrado cadrado : fichaActual.getCadrados()){
            Cadrado copiaCadrado = copiarCadrado(cadrado);
            copiaCadrado.setY(cadrado.getY()+movementoY);
            copiaCadrado.setX(cadrado.getX()+movementoX);
            //ventanaPrincipal.pintarCadrado(copiaCadrado.getLblCadrado());
            cadradosFantasma.add(copiaCadrado);
        }

        return cadradosFantasma;
    }

    private Cadrado copiarCadrado (Cadrado cadradoACopiar){
        Cadrado copiaCadrado = new Cadrado(cadradoACopiar.getX(), cadradoACopiar.getY(), cadradoACopiar.getCorRecheo());
        return copiaCadrado;
    }

    private void unirFichaOChan(Ficha fichaActual) {
        for (Cadrado cadrado : fichaActual.getCadrados()) {
            cadradosChan.add(cadrado);
        }
    }

    /**
     *  Comproba se unhas cordenadas de altura e anchura teñen unha posicion valida
     * @param x Posicion no eixe horizontal
     * @param y Posicion no eixe vertical
     * @return Resposta de se o elemento se atopa nun lugar valido
     */
    public Boolean ePosicionValida(int x, int y, int movementoY) {
        if(!estaFora(x,y)){
            if(!tocaOchan(y)){
                if(colisiona(x, y)){
                    if(movementoY == LADO_CADRADO){
                        finalFicha();
                        return false;
                    }
                }else {
                    return true;
                }
            }else {
                finalFicha();
            }
        }
        return false;
    }

    public void finalFicha(){
        unirFichaOChan(fichaActual);
     //   borrarLinasCompletas();
        xenerarNovaFicha();
    }

    /**
     * Comproba se unhas cordenadas son unha posicion que esta dentro do xogo
     * @param x Cordenada horizontal
     * @param y Cordenada vertical
     * @return Dinos se o lugar indicado se atopa dentro do xogo
     */
    public Boolean estaFora (int x, int y) {
        if (x + LADO_CADRADO > MAX_X || x < 0){
            System.out.println("Esta fora");
            System.out.println(x +" "+ y);
            return true;
        }else if (y > MAX_Y){
            System.out.println("Esta fora y max");
            System.out.println(x +" "+ y);
            return true;
        } else {
            System.out.println("Non esta fora");
            System.out.println(x +" "+ y);
            return false;
        }
    }

    /**
     * Comproba que a posicion de un cadrado e valida
     * @param cadrado Cadrado sobre o que se comproba a posicion
     * @return  Resposta de se o cadrado ten unha posicion valida
     */
    public boolean cadradoEPosicionValida(Cadrado cadrado,int movementoY){
        if(ePosicionValida(cadrado.getX(), cadrado.getY(),movementoY)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comproba se un array de cadrados teñen unha posicion valida
     * @param cadradosFicha Cadrados a comprobar
     * @return A resposta de se a posicion e valida
     */
    public boolean fichaEPosicionValida (ArrayList <Cadrado> cadradosFicha, int movementoY) {
        for(Cadrado cadrado : cadradosFicha){
            if (!cadradoEPosicionValida(cadrado, movementoY)) {
                return false;
            }
        }
        return true;
    }

    private Ficha debuxarNovaFicha(Ficha ficha){
        for (Cadrado cadrado : ficha.getCadrados()) {
            ventanaPrincipal.pintarCadrado(cadrado.getLblCadrado());
        }
        fichaActual = ficha;
        return ficha;
    }
    
    private Ficha xenerarNovaFicha() {
        Random r = new Random();
        int fichaAleatoria = r.nextInt((7)+1);
        switch (fichaAleatoria) {
            case 1:
                fichaActual = new FichaCadrada();
                break;
            case 2:
                fichaActual = new FichaL();
                break;
            case 3:
                fichaActual = new FichaJ();
                break;
            case 4:
                fichaActual = new FichaI();
                break;
            case 5:
                fichaActual = new FichaS();
                break;
            case 6:
                fichaActual = new FichaT();
                break;
            case 7:
                fichaActual = new FichaZ();
                break;
        }
        return debuxarNovaFicha(fichaActual);
    }
    
    private void engadirFichaAoChan() {
    	
    }
    
    private void borrarLinasCompletas() {
        for(int y = 0; y<MAX_Y; y += LADO_CADRADO) {
            for (int x = 0; x<MAX_X; x += LADO_CADRADO ){
                int contadorCadradosLiña = 0;
                for (Cadrado cadrado : cadradosChan){
                    if (cadrado.getY() == y && cadrado.getX() == x){
                        contadorCadradosLiña++;
                    }
                }
                if(contadorCadradosLiña == x/LADO_CADRADO){
                    borrarLina(y);
                }
            }
        }
    }


    
    private void borrarLina(int y) {
        for (Cadrado cadrado : cadradosChan){
            if (cadrado.getY() == y){
                cadradosChan.remove(cadrado);
                ventanaPrincipal.borrarCadrado(cadrado.getLblCadrado());
            }
        }
        baixarCadradosChan(y);
    }

    private void baixarCadradosChan(int y){
        for(Cadrado cadrado : cadradosChan){
            if (cadrado.getY() > y){
                cadrado.setY(y+LADO_CADRADO);
            }
        }
    }


    /**
     * Comproba se unhas coordenadas coinciden con coordenadas de un cadro bloqueado
     * @param x Posicion eixe horizontal
     * @param y Posicion eixe vertical
     * @return  Dinos se o obxeto colisiona ou non
     */
    private boolean colisiona(int x, int y) {
    	 for (Cadrado cadradoChan : cadradosChan) {
    	     if(x == cadradoChan.getX() && y==cadradoChan.getY()){
    	         return true;
             }
         }
    	 return false;
    }


    private boolean tocaOchan(int y){
        return y >= MAX_Y ;
    }

}