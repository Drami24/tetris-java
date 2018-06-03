package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import iu.VentanaPrincipal;
import tiposficha.*;

import javax.swing.*;

/**
 * Esta clase encargase das mecánicas do xogo
 */
public class Xogo {
    public final static int LADO_CADRADO = 30;
    public final static int MAX_X = 300;
    public final static int MAX_Y = 600;
    private boolean pausa;
    private byte numeroRotacion = 0;
    private int numeroLinas = 0;
    private int nivelDificultade = 1;
    private VentanaPrincipal ventanaPrincipal;
    private ArrayList<Cadrado> cadradosChan = new ArrayList<>();
    private Ficha fichaActual;
    private Timer timerXogo;

    public Xogo(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        ActionListener eventoTimer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverFichaAbaixo();
            }
        };
        timerXogo = new Timer(1000, eventoTimer);
        timerXogo.setInitialDelay(1000);
        timerXogo.setRepeats(true);
        timerXogo.start();
        xenerarNovaFicha();
    }

    private void subirDificultade() {
        if (timerXogo.getDelay() >= 150) {
            nivelDificultade++;
            ventanaPrincipal.mostrarDificultade(nivelDificultade);
            timerXogo.setDelay(timerXogo.getDelay() - 100);
        }
    }

    public void moverFichaDereita() {
        if(!pausa){
            int movementoY = 0;
            int movementoX = LADO_CADRADO;
            if (fichaEPosicionValida(xerarCadradosFantasma(movementoX, movementoY), movementoY)) {
                fichaActual.moverDereita();
            }
        }

    }

    public void moverFichaEsquerda() {
        if(!pausa){
            int movementoY = 0;
            int movementoX = -LADO_CADRADO;
            if (fichaEPosicionValida(xerarCadradosFantasma(movementoX, movementoY), movementoY)) {
                fichaActual.moverEsquerda();
            }
        }
    }

    public void moverFichaAbaixo() {
        if(!pausa){
            int movementoY = LADO_CADRADO;
            int movementoX = 0;
            ArrayList<Cadrado> cadradosFantasma = xerarCadradosFantasma(movementoX, movementoY);
            if (fichaEPosicionValida(cadradosFantasma, movementoY)) {
                fichaActual.moverAbaixo();
            }
        }
    }

    public void rotarFicha() {
        if(!pausa){
            numeroRotacion++;
            if(numeroRotacion > 3){
                numeroRotacion = 0;
            }
            ArrayList<Cadrado> fantasmaRotacion = fichaActual.obterFantasmaRotacion(numeroRotacion);
            if(fichaEPosicionValida(fantasmaRotacion)) {
                fichaActual.rotar(fantasmaRotacion);
            }
        }
    }

    private ArrayList<Cadrado> xerarCadradosFantasma(int movementoX, int movementoY) {
        ArrayList<Cadrado> cadradosFantasma = new ArrayList<>();
        for (Cadrado cadrado : fichaActual.getCadrados()) {
            Cadrado copiaCadrado = copiarCadrado(cadrado);
            copiaCadrado.setY(cadrado.getY() + movementoY);
            copiaCadrado.setX(cadrado.getX() + movementoX);
            //ventanaPrincipal.pintarCadrado(copiaCadrado.getLblCadrado());
            cadradosFantasma.add(copiaCadrado);
        }

        return cadradosFantasma;
    }

    private Cadrado copiarCadrado(Cadrado cadradoACopiar) {
        Cadrado copiaCadrado = new Cadrado(cadradoACopiar.getX(), cadradoACopiar.getY(), cadradoACopiar.getCorRecheo());
        return copiaCadrado;
    }

    private void unirFichaOChan(Ficha fichaActual) {
        for (Cadrado cadrado : fichaActual.getCadrados()) {
            cadradosChan.add(cadrado);
        }
    }

    /**
     * Comproba se unhas cordenadas de altura e anchura teñen unha posicion valida
     *
     * @param x Posicion no eixe horizontal
     * @param y Posicion no eixe vertical
     * @return Resposta de se o elemento se atopa nun lugar valido
     */
    public Boolean ePosicionValida(int x, int y, int movementoY) {
        if (!estaFora(x, y)) {
            if (!tocaOchan(y)) {
                if (colisiona(x, y)) {
                    if (movementoY == LADO_CADRADO) {
                        finalFicha();
                        return false;
                    }
                } else {
                    return true;
                }
            } else {
                finalFicha();
            }
        }
        return false;
    }

    public Boolean ePosicionValida(int x, int y) {
        if (!estaFora(x, y)) {
            if (!tocaOchan(y)) {
                if (colisiona(x, y)) {
                    return false;
                } else {
                    return true;
                }
            } else {
                finalFicha();
            }
        }
        return false;
    }

    public void finalFicha() {
        if (chegouFichaArriba()) {
            gameOver();
        } else {
            unirFichaOChan(fichaActual);
            xenerarNovaFicha();
            borrarLinasCompletas();
        }
    }

    /**
     * Comproba se unhas cordenadas son unha posicion que esta dentro do xogo
     *
     * @param x Cordenada horizontal
     * @param y Cordenada vertical
     * @return Dinos se o lugar indicado se atopa dentro do xogo
     */
    public Boolean estaFora(int x, int y) {
        if (x + LADO_CADRADO > MAX_X || x < 0) {
            return true;
        } else if (y > MAX_Y) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comproba que a posicion de un cadrado e valida
     *
     * @param cadrado Cadrado sobre o que se comproba a posicion
     * @return Resposta de se o cadrado ten unha posicion valida
     */
    public boolean cadradoEPosicionValida(Cadrado cadrado, int movementoY) {
        if (ePosicionValida(cadrado.getX(), cadrado.getY(), movementoY)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cadradoEPosicionValida(Cadrado cadrado) {
        if (ePosicionValida(cadrado.getX(), cadrado.getY())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comproba se un array de cadrados teñen unha posicion valida
     *
     * @param cadradosFicha Cadrados a comprobar
     * @return A resposta de se a posicion e valida
     */
    public boolean fichaEPosicionValida(ArrayList<Cadrado> cadradosFicha, int movementoY) {
        for (Cadrado cadrado : cadradosFicha) {
            if (!cadradoEPosicionValida(cadrado, movementoY)) {
                return false;
            }
        }
        return true;
    }

    public boolean fichaEPosicionValida(ArrayList<Cadrado> cadradosFicha) {
        for (Cadrado cadrado : cadradosFicha) {
            if (!cadradoEPosicionValida(cadrado)) {
                return false;
            }
        }
        return true;
    }

    private Ficha debuxarNovaFicha(Ficha ficha) {
        for (Cadrado cadrado : ficha.getCadrados()) {
            ventanaPrincipal.pintarCadrado(cadrado.getLblCadrado());
        }
        fichaActual = ficha;
        return ficha;
    }

    private Ficha xenerarNovaFicha() {
        Random r = new Random();
        int fichaAleatoria = r.nextInt(7);
        switch (fichaAleatoria) {
            case 0:
                fichaActual = new FichaCadrada();
                break;
            case 1:
                fichaActual = new FichaL();
                break;
            case 2:
                fichaActual = new FichaJ();
                break;
            case 3:
                fichaActual = new FichaI();
                break;
            case 4:
                fichaActual = new FichaS();
                break;
            case 5:
                fichaActual = new FichaT();
                break;
            case 6:
                fichaActual = new FichaZ();
                break;
        }
        return debuxarNovaFicha(fichaActual);
    }

    private void engadirFichaAoChan() {

    }

    private void borrarLinasCompletas() {
        for (int y = 0; y < MAX_Y; y += LADO_CADRADO) {
            if (estaLinhaCompleta(y)) {
                borrarLina(y);
            }
        }
    }

    private boolean estaLinhaCompleta(int cordenadaY) {
        int contadorCadradosFila = 0;
        for (int x = 0; x < MAX_X; x += LADO_CADRADO) {
            for (Cadrado cadrado : cadradosChan) {
                if (cadrado.getY() == cordenadaY && cadrado.getX() == x) {
                    contadorCadradosFila++;
                }
            }
        }
        if (contadorCadradosFila == MAX_X / LADO_CADRADO) {
            return true;
        } else {
            return false;
        }
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public boolean isPausa() {
        return pausa;
    }

    private void borrarLina(int y) {
        ArrayList<Cadrado> cadradosBufer = new ArrayList<>();
        cadradosBufer.addAll(cadradosChan);
        for (Cadrado cadrado : cadradosBufer) {
            if (cadrado.getY() == y) {
                cadradosChan.remove(cadrado);
                ventanaPrincipal.borrarCadrado(cadrado.getLblCadrado());
            }
        }
        numeroLinas++;
        ventanaPrincipal.mostrarNumeroLinas(numeroLinas);
        if (numeroLinas % 5 == 0) {
            subirDificultade();
        }
        baixarCadradosChan(y);
    }

    private void baixarCadradosChan(int y) {
        for (Cadrado cadrado : cadradosChan) {
            if (cadrado.getY() < y) {
                cadrado.setY(cadrado.getY() + LADO_CADRADO);
            }
        }
    }

    /**
     * Comproba se unhas coordenadas coinciden con coordenadas de un cadro bloqueado
     *
     * @param x Posicion eixe horizontal
     * @param y Posicion eixe vertical
     * @return Dinos se o obxeto colisiona ou non
     */
    private boolean colisiona(int x, int y) {
        for (Cadrado cadradoChan : cadradosChan) {
            if (x == cadradoChan.getX() && y == cadradoChan.getY()) {
                return true;
            }
        }
        return false;
    }

    private boolean tocaOchan(int y) {
        return y >= MAX_Y;
    }

    private void gameOver() {
        timerXogo.stop();
        ventanaPrincipal.mostrarFinDoXogo();
    }

    private boolean chegouFichaArriba() {
        for (Cadrado cadrado : fichaActual.getCadrados()) {
            if (cadrado.getY() == 0) {
                return true;
            }
        }
        return false;
    }

}