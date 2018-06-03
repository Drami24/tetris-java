package modelo;

import java.util.ArrayList;

public abstract class Ficha {
    private ArrayList<Cadrado> cadrados = new ArrayList<>();
    private Xogo xogo;

    public ArrayList<Cadrado> getCadrados() {
        return cadrados;
    }

    public void setCadrados(ArrayList<Cadrado> cadrados) {
        this.cadrados = cadrados;
    }

    public Xogo getXogo() {
        return xogo;
    }

    public boolean moverDereita() {
        for (Cadrado cadrado : cadrados) {
            cadrado.setX(cadrado.getX() + Xogo.LADO_CADRADO);
        }
        return true;
    }

    public boolean moverEsquerda() {
        for (Cadrado cadrado : cadrados) {
            cadrado.setX(cadrado.getX() - Xogo.LADO_CADRADO);
        }
        return true;
    }

    public boolean moverAbaixo() {
        for (Cadrado cadrado : cadrados) {
            cadrado.setY(cadrado.getY() + Xogo.LADO_CADRADO);
        }
        return true;
    }

    public boolean rotar(ArrayList<Cadrado> fantasmaFicha){
        for(int i = 0; i < cadrados.size(); i++){
            cadrados.get(i).setY(fantasmaFicha.get(i).getY());
            cadrados.get(i).setX(fantasmaFicha.get(i).getX());
        }
        return false;
    }

    public abstract ArrayList<Cadrado> obterFantasmaRotacion(int numeroRotacion);

    protected  ArrayList<Cadrado> crearFantasma (Cadrado cadrado0, Cadrado cadrado1, Cadrado cadrado2, Cadrado cadrado3){
        ArrayList<Cadrado> cadradosFantasma = new ArrayList<>();
        cadradosFantasma.add(cadrado0);
        cadradosFantasma.add(cadrado1);
        cadradosFantasma.add(cadrado2);
        cadradosFantasma.add(cadrado3);
        return cadradosFantasma;
    }

    protected Cadrado copiarCadrado(Cadrado cadradoACopiar) {
        Cadrado copiaCadrado = new Cadrado(cadradoACopiar.getX(), cadradoACopiar.getY(), cadradoACopiar.getCorRecheo());
        return copiaCadrado;
    }

}