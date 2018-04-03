package xogo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	
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
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panelXogo = new JPanel();
		contentPane.add(panelXogo, BorderLayout.CENTER);
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
