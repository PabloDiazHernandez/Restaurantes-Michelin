package dam.view;

import javax.swing.Icon;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dam.control.RestauranteControl;

import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;

public class VPrincipal extends JFrame {
	private static final int ANCHO = 900;
	private static final int ALTO = 700;
	public static final int ANCHO_PANEL = ANCHO - 30;
	public static final int ALTO_PANEL = ALTO - 70;

	public static final String MN_1 = "Mantenimiento Restaurantes";
	public static final String MANTENIMIENTO = "Mantenimiento Restaurantes";
	public static final String CONSULTA = "Consulta Restaurantes";
	public static final String REGISTRO = "Registro Restaurante";
	public static final String MODIFICAR = "Modificar Restaurante";
	public static final String SALIR = "Salir";

	public JMenuItem mntmSalir;
	private JMenuBar menuBar;

	public JMenuItem mntmConsultaRestaurantes;
	public JMenuItem mntmRegistroRestaurante;
	public JMenuItem mntmModificarRestaurante;
	public JMenu mnMenu1;
	private JScrollPane scrlContenedor;

	public VPrincipal() {

		init();
	}

	private void init() {
	//	getContentPane().setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("** GUIA MICHELIN **");
		crearMenu();
		setSize(ANCHO, ALTO);
		centrarVentana();

	}

	private void crearMenu() {
	
		menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		setJMenuBar(menuBar);

		mnMenu1 = new JMenu(MN_1);
		mnMenu1.setHorizontalAlignment(SwingConstants.LEFT);
		mnMenu1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		menuBar.add(mnMenu1);

		mntmConsultaRestaurantes = new JMenuItem(CONSULTA);
		mntmConsultaRestaurantes.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		mnMenu1.add(mntmConsultaRestaurantes);

		mntmRegistroRestaurante = new JMenuItem(REGISTRO);
		mntmRegistroRestaurante.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		mnMenu1.add(mntmRegistroRestaurante);

		mntmModificarRestaurante = new JMenuItem(MODIFICAR);
		mntmModificarRestaurante.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		mnMenu1.add(mntmModificarRestaurante);

		mntmSalir = new JMenuItem(SALIR);
		mntmSalir.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		menuBar.add(mntmSalir);
		getContentPane().setLayout(null);

		scrlContenedor = new JScrollPane();
		scrlContenedor.setBounds(0, 0, 876, 634);
		getContentPane().add(scrlContenedor);

	}

	private void centrarVentana() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getPreferredSize();
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void setControlador(RestauranteControl rc) {

		mnMenu1.addActionListener(rc);

		mntmRegistroRestaurante.addActionListener(rc);
		mntmConsultaRestaurantes.addActionListener(rc);
		mntmModificarRestaurante.addActionListener(rc);
		mntmSalir.addActionListener(rc);

	}

	public void mostrarPanel(JPanel panel) {

		scrlContenedor.setViewportView(panel);

	}

	public void opcionSalir() {
		int repuesta = JOptionPane.showConfirmDialog(this, "Se va a cerrar la aplicación ",
				"Confirmacion cierre de aplicación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

		if (repuesta == JOptionPane.YES_OPTION) {

			System.exit(0);
		}

	}

}
