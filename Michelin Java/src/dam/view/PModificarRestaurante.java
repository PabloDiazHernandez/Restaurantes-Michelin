package dam.view;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import dam.control.RestauranteControl;
import dam.model.Restaurante;

public class PModificarRestaurante extends JPanel {

	private static final String[] REGION = { "Andaluc\u00EDa", "Arag\u00F3n", "Asturias", "Islas Baleares", "Cantabria",
			"Islas Canarias", "Castilla - La Mancha", "Castilla y Le\u00F3n", "Catalu\u00F1a", "Galicia", "Extremadura",
			"Madrid", "Murcia", "Navarra", "Pa\u00EDs Vasco", "La Rioja", "Comunidad Valenciana" };
	private static final String[] COCINA = { "Creativa", "Moderna", "Tradicional", "Regional", "Fusi\u00F3n" };
	public static final String BTN_GUARDAR = "Modificar ";

	public static final String BTN_CANCELAR = "Cancelar";
	public static final String BTN_BUSCAR = "Buscar";
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JSpinner spnDistincion;
	private JTextField txtCiudad;
	private JTextField txtPrecioMax;
	private JTextField txtPrecioMin;
	private JButton btnGuardarDatos;
	private JButton btnCancelar;
	private JComboBox<String> cmbCocina;
	private JComboBox<String> cmbRegion;
	private JLabel lblWeb;
	private JTextField txtWeb;
	private JButton btnBuscar;

	public PModificarRestaurante() {
		setLayout(null);

		setSize(795, 586);
		JLabel lblModificarRestaurantes = new JLabel("Modificar Restaurantes");
		lblModificarRestaurantes.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 22));
		lblModificarRestaurantes.setBounds(24, 47, 227, 28);
		add(lblModificarRestaurantes);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblNombre.setBounds(50, 123, 101, 20);
		add(lblNombre);

		JLabel lblRegion = new JLabel("Regi\u00F3n: ");
		lblRegion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblRegion.setBounds(50, 164, 101, 20);
		add(lblRegion);

		JLabel lblDireccion = new JLabel("Direcci\u00F3n: ");
		lblDireccion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblDireccion.setBounds(50, 207, 101, 20);
		add(lblDireccion);

		JLabel lblDistincion = new JLabel("Distinci\u00F3n: ");
		lblDistincion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblDistincion.setBounds(50, 259, 101, 20);
		add(lblDistincion);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono: ");
		lblTelfono.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblTelfono.setBounds(50, 309, 101, 20);
		add(lblTelfono);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		txtNombre.setBounds(166, 113, 244, 28);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(166, 301, 199, 28);
		add(txtTelefono);

		cmbRegion = new JComboBox<String>();
		cmbRegion.setModel(new DefaultComboBoxModel<String>(REGION));
		cmbRegion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		cmbRegion.setBounds(166, 155, 172, 28);
		add(cmbRegion);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(166, 204, 306, 28);
		add(txtDireccion);

		spnDistincion = new JSpinner();
		spnDistincion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		spnDistincion.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spnDistincion.setBounds(166, 250, 53, 28);
		add(spnDistincion);

		JLabel lblCocina = new JLabel("Cocina: ");
		lblCocina.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblCocina.setBounds(478, 207, 62, 20);
		add(lblCocina);

		cmbCocina = new JComboBox<String>();
		cmbCocina.setModel(new DefaultComboBoxModel<String>(COCINA));
		cmbCocina.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		cmbCocina.setBounds(550, 203, 172, 29);
		add(cmbCocina);

		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblCiudad.setBounds(410, 164, 62, 20);
		add(lblCiudad);

		txtCiudad = new JTextField();
		txtCiudad.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(483, 156, 244, 28);
		add(txtCiudad);

		JLabel lblPrecioMax = new JLabel("Precio Max: ");
		lblPrecioMax.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblPrecioMax.setBounds(349, 260, 73, 18);
		add(lblPrecioMax);

		txtPrecioMax = new JTextField();
		txtPrecioMax.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		txtPrecioMax.setBounds(421, 258, 96, 21);
		add(txtPrecioMax);
		txtPrecioMax.setColumns(10);

		JLabel lblPrecioMin = new JLabel("Precio Min: ");
		lblPrecioMin.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblPrecioMin.setBounds(555, 260, 73, 18);
		add(lblPrecioMin);

		txtPrecioMin = new JTextField();
		txtPrecioMin.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		txtPrecioMin.setColumns(10);
		txtPrecioMin.setBounds(631, 258, 96, 21);
		add(txtPrecioMin);

		btnGuardarDatos = new JButton(BTN_GUARDAR);
		btnGuardarDatos.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		btnGuardarDatos.setBounds(217, 381, 172, 28);
		add(btnGuardarDatos);

		btnCancelar = new JButton(BTN_CANCELAR);
		btnCancelar.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		btnCancelar.setBounds(483, 381, 172, 28);
		add(btnCancelar);

		lblWeb = new JLabel("Web: ");
		lblWeb.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblWeb.setBounds(399, 311, 62, 20);
		add(lblWeb);

		txtWeb = new JTextField();
		txtWeb.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		txtWeb.setColumns(10);
		txtWeb.setBounds(456, 306, 271, 28);
		add(txtWeb);

		btnBuscar = new JButton(BTN_BUSCAR);
		btnBuscar.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		btnBuscar.setBounds(478, 113, 131, 29);
		add(btnBuscar);
	}

	public void mostrarError(String error) {

		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void mostrarValidacion(String validar) {
		JOptionPane.showMessageDialog(this, validar, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	}

	public Restaurante modificarRestaurante() {
		Restaurante rest = null;

		try {

			String ciudad = txtCiudad.getText().trim();

			if (ciudad.isEmpty()) {
				mostrarError("Debe de introducir una ciudad.");

			} else {
				String preMax = txtPrecioMax.getText().trim();
				String preMin = txtPrecioMin.getText().trim();
				double precioMax = Double.parseDouble(preMax);
				double precioMin = Double.parseDouble(preMin);

				if (precioMax < precioMin) {

					mostrarError("El precio min no puede ser mayor que el precio Máximo.");
				} else {
					String nombre = txtNombre.getText();
					String region = (String) cmbRegion.getSelectedItem();
					String direccion = txtDireccion.getText().trim();
					int distincion = (int) spnDistincion.getValue();
					String telefono = txtTelefono.getText().trim();
					String Web = txtWeb.getText().trim();
					String cocina = (String) cmbCocina.getSelectedItem();
					int id = 0;
					rest = new Restaurante(nombre, region, ciudad, distincion, direccion, precioMin, precioMax,
							telefono, cocina, Web);
					limpiarDatos();
				}
			}

		} catch (NumberFormatException e) {

			mostrarError("El precio min y el máximo deben de ser númericos.");
		}

		return rest;
	}

	public void limpiarDatos() {

		txtNombre.setText("");
		txtCiudad.setText("");
		txtDireccion.setText("");
		txtPrecioMax.setText("");
		txtPrecioMin.setText("");
		txtTelefono.setText("");
		txtWeb.setText("");
		cmbCocina.setSelectedIndex(0);
		cmbRegion.setSelectedIndex(0);
		spnDistincion.setValue(1);

	}

	public String buscarNombreRest() {
		return txtNombre.getText().trim();
	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void setControlador(RestauranteControl rc) {
		btnBuscar.addActionListener(rc);
		btnCancelar.addActionListener(rc);
		btnGuardarDatos.addActionListener(rc);

	}

	public void activarComponentes(boolean b) {

		btnCancelar.setEnabled(b);
		btnGuardarDatos.setEnabled(b);
		txtCiudad.setEnabled(b);
		txtDireccion.setEnabled(b);
		txtPrecioMax.setEnabled(b);
		txtPrecioMin.setEnabled(b);
		txtTelefono.setEnabled(b);
		cmbRegion.setEnabled(b);
		cmbCocina.setEnabled(b);
		spnDistincion.setEnabled(b);
		txtWeb.setEnabled(b);

	}

	public void ocultarNombre(boolean b) {
		txtNombre.setEnabled(b);
		btnBuscar.setEnabled(b);
	}

	public void cargarDatos(Restaurante rest) {

		txtNombre.setText(rest.getNombre());
		txtCiudad.setText(rest.getCiudad());
		txtDireccion.setText(rest.getDireccion());
		txtPrecioMax.setText(String.valueOf(rest.getPrecio_max()));
		txtPrecioMin.setText(String.valueOf(rest.getPrecio_min()));
		txtTelefono.setText(rest.getTelefono());
		txtWeb.setText(rest.getWeb());
		cmbCocina.setSelectedItem(rest.getCocina());
		cmbRegion.setSelectedItem(rest.getRegion());
		spnDistincion.setValue(Integer.parseInt(rest.getDistincion()));

	}

}
