package iu;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Xogo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {
	
	private JFrame frame;
	private Timer timer;
	private JPanel panelXogo;
	private JPanel panelTetris;
	private JToggleButton tglbtnPausa;
	private JLabel lblNumlinas;
	private Xogo xogoActual = null;
    JButton btnNovaPartida;
	
	JLabel nCadrado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		initialize();
        crearPanelXogo();
        JPanel contentPane = engadirContentPane(frame);
        contentPane.add(panelXogo, BorderLayout.CENTER);
        crearBotonsControlXogo();
        engadirPanelTetris();
	}

	private void initialize() {
	    frame = new JFrame();
		asignarPropiedadesAVentana(frame);
	}

	private void iniciarPartida(){
        System.out.println("click");
		xogoActual = new Xogo(this);
	}
	
    public void pintarCadrado(JLabel lblCadrado) {
		panelTetris.add(lblCadrado);
		panelTetris.repaint();
	}
	
	public void borrarCadrado(JLabel lblCadrado) {
		
	}

	public void mostrarNumeroLinas(int numeroLinas){

    }

    public void mostrarFinDoXogo(){

    }

    private JPanel crearPanelXogo(){
		panelXogo = new JPanel();
		panelXogo.setBackground(Color.LIGHT_GRAY);
        panelXogo.setLayout(null);
        panelXogo.add(crearBotonNovaPartida());
        panelXogo.add(crearBotonPausa());
		panelXogo.setVisible(true);
		return panelXogo;
	}

	private JPanel engadirContentPane(JFrame frame) {
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		return contentPane;
	}

	private void asignarPropiedadesAVentana(JFrame frame){
		frame.setBounds(100, 100, 400, 761);
		frame.setTitle("Tetris by @damianld");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	private JButton crearBotonNovaPartida(){
	    btnNovaPartida = new JButton("Nova Partida");
		btnNovaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarPartida();
			}
		});
		btnNovaPartida.setBounds(62, 0, 100, 23);
		return btnNovaPartida;
	}

	private JToggleButton crearBotonPausa() {
        tglbtnPausa = new JToggleButton("Pausa");
        tglbtnPausa.setBounds(223, 0, 100, 23);
	    return tglbtnPausa;
    }

    private void crearBotonsControlXogo() {
        JButton btnEsquerda = new JButton("Esquerda");
        btnEsquerda.setBounds(73, 651, 89, 23);
        panelXogo.add(btnEsquerda);

        JButton btnDereita = new JButton("Dereita");
        btnDereita.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		xogoActual.moverFichaDereita();
        	}
        });
        btnDereita.setBounds(199, 651, 89, 23);
        panelXogo.add(btnDereita);

        JButton btnAbaixo = new JButton("Abaixo");
        btnAbaixo.setBounds(73, 685, 89, 23);
        panelXogo.add(btnAbaixo);

        JButton btnRotar = new JButton("Rotar");
        btnRotar.setBounds(199, 685, 89, 23);
        panelXogo.add(btnRotar);
    }

    private void engadirPanelTetris(){
        panelTetris = new JPanel();
        panelTetris.setBounds(41, 40, 300, 600);
        panelXogo.add(panelTetris);
        panelTetris.setLayout(null);
    }

    public JLabel obterCadradoDeProba() {
        nCadrado = new JLabel();
        nCadrado.setBounds(0, 0, 30, 30);
        nCadrado.setBackground(Color.BLUE);
        nCadrado.setOpaque(true);
        nCadrado.setVisible(true);
        nCadrado.setBorder(new LineBorder(Color.BLACK, 2));
        return nCadrado;
    }

    public void probaPintarCadrado() {
        nCadrado = new JLabel();
        nCadrado.setBounds(0, 0, 30, 30);
        nCadrado.setBackground(Color.BLUE);
        nCadrado.setOpaque(true);
        nCadrado.setBorder(new LineBorder(Color.BLACK, 2));
        pintarCadrado(nCadrado);
        //panelTetris.add(nCadrado);
    }
}

