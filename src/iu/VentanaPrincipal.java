package iu;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import modelo.Xogo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Esta clase encárgase de mostrar a interfaz gráfica da aplicación
 * 
 * @author damianld
 *
 */
public class VentanaPrincipal {

	/**
	 * Contedor dos compoñentes da interfaz gráfica
	 */
	private JFrame frame;
	/**
	 * Panel onde se visualizan os compoñentes gráficos
	 */
	private JPanel panelXogo;
	/**
	 * Panel onde se visualizan as fichas do Tetris
	 */
	private JPanel panelTetris;
	/**
	 * Encárgase de baixar automáticamente as fichas do Tetris
	 */
	private Timer timer;
	/**
	 * Botón que permite pausar a partida
	 */
	private JToggleButton tglbtnPausa;
	/**
	 * Mostra o número de liñas eliminadas
	 */
	private JLabel lblNumlinas;
	/**
	 * O encargado de iniciar a partida
	 */
	private Xogo xogoActual = null;

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
	}

	/**
	 * Encárgase de crear os compoñentes coas súas propiedades correspondentes
	 */
	private void initialize() {
		frame = new JFrame();
		asignarPropiedadesDoFrame(frame);
		JPanel contentPane = engadirContentPane(frame);
		crearPanelXogo();
		contentPane.add(panelXogo, BorderLayout.CENTER);
		crearBotonsControlXogo();
		engadirPanelTetris();
	}

	/**
	 * Este método encárgase de iniciar a partida do Tetris
	 */
	private void iniciarPartida() {
		panelTetris.removeAll();
		xogoActual = new Xogo(this);
	}

	public void pintarCadrado(JLabel lblCadrado) {
		panelTetris.add(lblCadrado);
		panelTetris.repaint();
	}

	public void borrarCadrado(JLabel lblCadrado) {
		panelTetris.remove(lblCadrado);
		panelTetris.repaint();
	}

	public void mostrarNumeroLinas(int numeroLinas) {
		xogoActual.getNumeroLinas();
		System.out.println(xogoActual.getNumeroLinas());
	}

	public void mostrarFinDoXogo() {

	}

	private JPanel engadirContentPane(JFrame frame) {
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		return contentPane;
	}

	/**
	 * Establece as propiedades do frame
	 * 
	 * @param frame
	 *            Frame onde afectan as propiedades
	 */
	private void asignarPropiedadesDoFrame(JFrame frame) {
		frame.setBounds(600, 50, 550, 660);
		frame.setTitle("Tetris by @damianld");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Este método é o encargado de de crear o panelXogo
	 * 
	 * @return panelXogo coas súas propiedades
	 */
	private JPanel crearPanelXogo() {
		panelXogo = new JPanel();
		panelXogo.setLayout(null);
		panelXogo.setBackground(Color.GRAY);
		panelXogo.add(crearBotonNovaPartida());
		panelXogo.add(crearBotonPausa());
		panelXogo.setVisible(true);
		return panelXogo;
	}

	/**
	 * 
	 * @return
	 */
	private JButton crearBotonNovaPartida() {
		JButton btnNovaPartida = new JButton("Nova Partida");
		btnNovaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarPartida();
			}
		});
		btnNovaPartida.setBounds(324, 12, 150, 23);
		btnNovaPartida.setFocusable(false);
		return btnNovaPartida;
	}

	/**
	 * 
	 * @return
	 */
	private JToggleButton crearBotonPausa() {
		tglbtnPausa = new JToggleButton("Pausa");
		tglbtnPausa.setBounds(324, 47, 150, 23);
		tglbtnPausa.setFocusable(false);
		return tglbtnPausa;
	}

	private JLabel crearLabelNumLinas() {
//		lblNumlinas =  
		return null;
	}
	
	private void crearBotonsControlXogo() {
		JButton btnEsquerda = new JButton("Esquerda");
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xogoActual.moverFichaEsquerda();
			}
		});
		btnEsquerda.setBounds(324, 473, 89, 23);
		panelXogo.add(btnEsquerda);

		JButton btnDereita = new JButton("Dereita");
		btnDereita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xogoActual.moverFichaDereita();
			}
		});
		btnDereita.setBounds(425, 473, 89, 23);
		panelXogo.add(btnDereita);

		JButton btnAbaixo = new JButton("Abaixo");
		btnAbaixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xogoActual.moverFichaAbaixo();
			}
		});
		btnAbaixo.setBounds(324, 511, 89, 23);
		panelXogo.add(btnAbaixo);

		JButton btnRotar = new JButton("Rotar");
		btnRotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRotar.setBounds(425, 508, 89, 23);
		panelXogo.add(btnRotar);
	}

	private void engadirPanelTetris() {
		panelTetris = new JPanel();
		panelTetris.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					xogoActual.moverFichaEsquerda();
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					xogoActual.moverFichaDereita();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					xogoActual.moverFichaAbaixo();
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					xogoActual.rotarFicha();
					System.out.println("arriba");
				}
			}
		});
		panelTetris.setBackground(Color.DARK_GRAY);
		panelTetris.setBounds(12, 12, 300, 600);
		panelTetris.setFocusable(true);
		panelXogo.add(panelTetris);
		panelTetris.setLayout(null);
		
		lblNumlinas = new JLabel("Liñas eliminadas ");
		lblNumlinas.setForeground(Color.WHITE);
		lblNumlinas.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNumlinas.setBounds(324, 107, 150, 14);
		panelXogo.add(lblNumlinas);
	}
	
}