package xogo;

import java.util.ArrayList;

public class Xogo {
    private final int LADO_CADRADO = 30;
    private final int MAX_X = 300;
    private final int MAX_Y = 900;
    private boolean pausa;
    private int numeroLinas;
    private VentanaPrincipal ventanaPrincipal;
    private ArrayList<Cadrado> cadradosChan;

    public Xogo (VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
    }
}
