package iu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import java.awt.Color;

public class VentanaPrincipal extends JFrame {
	
	private Timer timer;
	private JPanel contentPane;
	private JPanel panelXogo;
	private JPanel panelTetris;
	private JToggleButton tglbtnPausa;
	private JLabel lblNumlinas;
	private Xogo xogoActual = null;
	JLabel nCadrado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 900);
		setTitle("Tetris by @damianld");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panelXogo = new JPanel();
		panelXogo.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelXogo, BorderLayout.CENTER);
		panelXogo.setLayout(null);
		
		JButton btnNewButton = new JButton("Nova Partida");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarPartida();
			}
		});
		btnNewButton.setBounds(10, 11, 155, 23);
		panelXogo.add(btnNewButton);
		
		tglbtnPausa = new JToggleButton("Pausa");
		tglbtnPausa.setBounds(303, 11, 121, 23);
		panelXogo.add(tglbtnPausa);
		
		JButton btnEsquerda = new JButton("Esquerda");
		btnEsquerda.setBounds(109, 769, 89, 23);
		panelXogo.add(btnEsquerda);
		
		JButton btnDereita = new JButton("Dereita");
		btnDereita.setBounds(220, 769, 89, 23);
		panelXogo.add(btnDereita);
		
		JButton btnAbaixo = new JButton("Abaixo");
		btnAbaixo.setBounds(109, 803, 89, 23);
		panelXogo.add(btnAbaixo);
		
		JButton btnRotar = new JButton("Rotar");
		btnRotar.setBounds(220, 803, 89, 23);
		panelXogo.add(btnRotar);
		
		panelTetris = new JPanel();
		panelTetris.setBounds(20, 47, 392, 696);
		panelXogo.add(panelTetris);
		panelTetris.setLayout(null);
		
		nCadrado = new JLabel();
		nCadrado.setBounds(0, 0, 30, 30);
		nCadrado.setBackground(Color.BLUE);
		nCadrado.setOpaque(true);
		nCadrado.setBorder(new LineBorder(Color.BLACK, 2));
		//pintarCadrado(nCadrado);
		
	}

	private void iniciarPartida(){
		//xogoActual = new Xogo(this);
		pintarCadrado(nCadrado);
		System.out.println("click");
	}
	
	public void pintarCadrado(JLabel lblCadrado) {
		panelTetris.add(lblCadrado);
	}
	
	public void borrarCadrado(JLabel lblCadrado) {
		
	}

	public void mostrarNumeroLinas(int numeroLinas){

    }

    public void mostrarFinDoXogo(){

    }
}

