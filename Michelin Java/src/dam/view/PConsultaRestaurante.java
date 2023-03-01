package dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dam.control.RestauranteControl;
import dam.db.persistencia.RestauranteContract;
import dam.model.Restaurante;

public class PConsultaRestaurante extends JPanel {

	private static final String[] DISTINCION = { "TODAS ", "1 ESTRELLA", "2 ESTRELLAS", "3 ESTRELLAS" };

	public static final String BTN_CONSULTAR = "Consultar";

	public static final String BTN_ELIMINAR = "Eliminar";

	public JButton btnConsultar;
	private JTable tblListaRestaurantes;
	private DefaultTableModel dtm;
	private JScrollPane scrpContenedor;
	private JComboBox<String> cmbRegion;
	private JComboBox<String> cmbDistincion;
	private DefaultComboBoxModel<String> cmb_def;
	private JButton btnEliminar;

	public PConsultaRestaurante() {
		setLayout(null);

		JLabel lblConsultaRestaurantes = new JLabel("Consultar Restaurantes");
		lblConsultaRestaurantes.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 22));
		lblConsultaRestaurantes.setBounds(25, 33, 234, 28);
		add(lblConsultaRestaurantes);

		JLabel lblFiltro = new JLabel("Filtro: ");
		lblFiltro.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblFiltro.setBounds(96, 105, 58, 28);
		add(lblFiltro);

		JLabel lblRegion = new JLabel("Region: ");
		lblRegion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblRegion.setBounds(131, 158, 58, 28);
		add(lblRegion);

		JLabel lblDistincion = new JLabel("Distinci\u00F3n:");
		lblDistincion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblDistincion.setBounds(535, 158, 93, 28);
		add(lblDistincion);

		cmbRegion = new JComboBox<String>();
		cmbRegion.setModel(cmb_def = new DefaultComboBoxModel<String>());
		cmbRegion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		cmbRegion.setBounds(199, 160, 234, 21);
		add(cmbRegion);

		cmbDistincion = new JComboBox<String>();
		cmbDistincion.setModel(new DefaultComboBoxModel<String>(DISTINCION));
		cmbDistincion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		cmbDistincion.setBounds(640, 160, 184, 21);
		add(cmbDistincion);

		btnConsultar = new JButton(BTN_CONSULTAR);
		btnConsultar.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		btnConsultar.setBounds(702, 229, 149, 28);
		add(btnConsultar);

		JLabel lblNewLabel = new JLabel("Listado de Resturantes");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(24, 270, 211, 28);
		add(lblNewLabel);

		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(77, 308, 774, 255);
		add(scrpContenedor);

		tblListaRestaurantes = new JTable();
		tblListaRestaurantes.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 10));
		scrpContenedor.setViewportView(tblListaRestaurantes);

		btnEliminar = new JButton(BTN_ELIMINAR);
		btnEliminar.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		btnEliminar.setBounds(702, 589, 149, 28);

		add(btnEliminar);
		configurarTabla();

	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void setControlador(RestauranteControl rc) {

		btnConsultar.addActionListener(rc);
		btnEliminar.addActionListener(rc);

	}

	public void configurarTabla() {
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.addColumn(RestauranteContract.COL_NOMBRE);
		dtm.addColumn(RestauranteContract.COL_CIUDAD);
		dtm.addColumn(RestauranteContract.COL_DISTINCION);
		dtm.addColumn(RestauranteContract.COL_COCINA);
		dtm.addColumn(RestauranteContract.COL_PRECIO);
		tblListaRestaurantes.setModel(dtm);
		tblListaRestaurantes.getColumn(RestauranteContract.COL_NOMBRE).setPreferredWidth(150);
		tblListaRestaurantes.getColumn(RestauranteContract.COL_CIUDAD).setPreferredWidth(150);
		tblListaRestaurantes.getColumn(RestauranteContract.COL_DISTINCION).setPreferredWidth(150);
		tblListaRestaurantes.getColumn(RestauranteContract.COL_COCINA).setPreferredWidth(150);
		tblListaRestaurantes.getColumn(RestauranteContract.COL_PRECIO).setPreferredWidth(150);

		tblListaRestaurantes.setModel(dtm);

	}

	public void mostrarComponentes(boolean bool) {
		scrpContenedor.setVisible(bool);
		tblListaRestaurantes.setVisible(bool);
		btnEliminar.setVisible(bool);

	}

	public int filtrarRestauranteDistincion() {
		return cmbDistincion.getSelectedIndex();

	}

	public void cargarCombo(ArrayList<String> listRegion) {
		cmb_def.removeAllElements();
		cmb_def.addElement("TODAS");
		for (String reg : listRegion) {

			cmb_def.addElement(reg);
		}

	}

	public void rellenarTabla(ArrayList<Restaurante> listadoRest) {
		dtm.setRowCount(0);

		Object[] datosRest = new Object[5];

		if (!listadoRest.isEmpty()) {

			for (Restaurante rest : listadoRest) {

				datosRest[0] = rest.getNombre();
				datosRest[1] = rest.getCiudad();
				datosRest[2] = rest.getDistincion();
				datosRest[3] = rest.getCocina();
				datosRest[4] = rest.getPrecio();
				dtm.addRow(datosRest);

			}

		}
	}

	public String obtnerFilRegion() {

		return (String) cmbRegion.getSelectedItem();

	}

	public String eliminarRest() {

		int fila = tblListaRestaurantes.getSelectedRow();
		String valor = "";

		if (fila != -1) {

			valor = (String) tblListaRestaurantes.getValueAt(fila, 0);
			mostrarValidacion("Restaurante Eliminado satisfactoriamente.");
			dtm.removeRow(fila);

		} else {

			mostrarError("Debes de seleccionar una fila");
		}

		return valor;
	}

	public void mostrarError(String error) {

		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void mostrarValidacion(String validar) {
		JOptionPane.showMessageDialog(this, validar, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarElementos(boolean b) {
		tblListaRestaurantes.setVisible(b);
		btnEliminar.setVisible(b);
	}

}
