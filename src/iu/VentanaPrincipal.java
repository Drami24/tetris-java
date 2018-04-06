package iu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import modelo.Xogo;
import tiposficha.FichaCadrada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {
	
	private Timer timer;
	private JPanel contentPane;
	private JPanel panelXogo;
	private JToggleButton tglbtnPausa;
	private JLabel lblNumlinas;
	private Xogo xogoActual = null;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 47, 392, 696);
		panelXogo.add(panel);
	}

	private void iniciarPartida(){

    }
	
	public void pintarCadrado(JLabel lblCadrado) {
		
	}
	
	public void borrarCadrado(JLabel lblCadrado) {
		
	}

	public void mostrarNumeroLinas(int numeroLinas){

    }

    public void mostrarFinDoXogo(){

    }
}

