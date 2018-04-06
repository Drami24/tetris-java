package modelo;

import javax.swing.*;
import java.awt.*;

public class Cadrado {
	
    private int x;
    private int y;
    private Color corRecheo;
    private JLabel lblCadrado;
    
    public Cadrado(int x, int y, Color corRecheo, JLabel lblCadrado) {
    	this.x = x;
    	this.y = y;
    	this.corRecheo = corRecheo;
    	this.lblCadrado = lblCadrado;
    }

    public String getCoordenadas() {
        return String.valueOf(x) + String.valueOf(y);
    }

}