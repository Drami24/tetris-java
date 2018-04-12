package modelo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Cadrado{
	
    private int x;
    private int y;
    private Color corRecheo;
    private JLabel lblCadrado;
    
    public Cadrado(int x, int y, Color corRecheo) {
    	this.x = x;
    	this.y = y;
    	this.corRecheo = corRecheo;
    	JLabel cadrado = new JLabel("asd");
    	cadrado.setBounds(this.x, this.y, Xogo.LADO_CADRADO, Xogo.LADO_CADRADO);
    	cadrado.setOpaque(true);
    	cadrado.setBorder(new LineBorder(Color.BLACK, 5));
    	this.lblCadrado = cadrado;
    }

    public String getCoordenadas() {
        return String.valueOf(x) + String.valueOf(y);
    }

    public JLabel getLblCadrado(){
        return lblCadrado;
    }

}