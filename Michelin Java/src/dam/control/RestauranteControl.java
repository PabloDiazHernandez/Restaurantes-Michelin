package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import dam.db.persistencia.RestaurantePersistencia;
import dam.model.Restaurante;
import dam.view.PConsultaRestaurante;
import dam.view.PRegistrarRestaurante;
import dam.view.PModificarRestaurante;
import dam.view.VPrincipal;

public class RestauranteControl implements ActionListener {

	PConsultaRestaurante pConsulta;
	PRegistrarRestaurante pRegistrar;
	PModificarRestaurante pModificar;
	VPrincipal vPrincipal;
	RestaurantePersistencia restPersist;

	public RestauranteControl(PConsultaRestaurante pConsulta, PRegistrarRestaurante pEliminar,
			PModificarRestaurante pModificar, VPrincipal vPrincipal) {

		this.pConsulta = pConsulta;
		this.pRegistrar = pEliminar;
		this.pModificar = pModificar;
		this.vPrincipal = vPrincipal;
		restPersist = new RestaurantePersistencia();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			if (e.getActionCommand().equals(VPrincipal.CONSULTA)) {
				pConsulta.cargarCombo(restPersist.obtenerRegiones());
				pConsulta.mostrarComponentes(false);
				vPrincipal.mostrarPanel(pConsulta);

			} else if (e.getActionCommand().equals(VPrincipal.MODIFICAR)) {

				vPrincipal.mostrarPanel(pModificar);
				pModificar.activarComponentes(false);
			} else if (e.getActionCommand().equals(VPrincipal.REGISTRO)) {
				vPrincipal.mostrarPanel(pRegistrar);
			} else if (e.getActionCommand().equals(VPrincipal.SALIR)) {
				vPrincipal.opcionSalir();
			}
		} else if (e.getSource() instanceof JButton) {

			if (e.getActionCommand().equals(PConsultaRestaurante.BTN_CONSULTAR)) {
				consultarRestaurantes();

			}

			else if (e.getActionCommand().equals(PConsultaRestaurante.BTN_ELIMINAR)) {

				eliminarRest();

			} else if (e.getActionCommand().equals(PRegistrarRestaurante.BTN_GUARDAR)) {
				registrarRest();

			} else if (e.getActionCommand().equals(PRegistrarRestaurante.LIMPIAR_DATOS)) {
				pRegistrar.limpiarDatos();
			} else if (e.getActionCommand().equals(PModificarRestaurante.BTN_BUSCAR)) {
				buscarNombreRest();
			} else if (e.getActionCommand().equals(PModificarRestaurante.BTN_GUARDAR)) {
				modificarRest();
				pModificar.activarComponentes(false);
				pModificar.ocultarNombre(true);
			} else if (e.getActionCommand().equals(PModificarRestaurante.BTN_CANCELAR)) {
				pModificar.mostrarError("Operación cancelada.");
				pModificar.activarComponentes(false);
				pModificar.ocultarNombre(true);
				pModificar.limpiarDatos();
			

			}
		}

	}

	private void consultarRestaurantes() {
		ArrayList<Restaurante> listRegion = new ArrayList<>();
		int distincion = pConsulta.filtrarRestauranteDistincion();
		String region = pConsulta.obtnerFilRegion();
		String dist = Integer.toString(distincion);

		if (region.equals("TODAS") && distincion == 0) {

			listRegion = restPersist.ConsultarRestRegion(region);
			pConsulta.rellenarTabla(restPersist.ListadoRest());

		} else if (!region.equals("TODAS") && distincion == 0) {

			listRegion = restPersist.ConsultarRestRegion(region);
			pConsulta.rellenarTabla(listRegion);
		} else if (region.equals("TODAS") && distincion != 0) {

			listRegion = restPersist.ConsultarRestDist(dist);
			pConsulta.rellenarTabla(listRegion);
		} else {
			listRegion = restPersist.ConsultarRestReg_distin(region, dist);
			pConsulta.rellenarTabla(listRegion);
		}

		pConsulta.mostrarComponentes(true);
	}

	private void modificarRest() {

		Restaurante rest = pModificar.modificarRestaurante();

		if (rest != null) {

			int insertRest = restPersist.modificarRestaurante(rest);

			if (insertRest == 1) {

				pModificar.mostrarValidacion("Restaurante modificado correctamente.");

			} else {

				pRegistrar.mostrarError("No se ha podido modificar el restaurante.");
				pModificar.activarComponentes(false);
			}
		}
	}

	private void buscarNombreRest() {

		String nom = pModificar.buscarNombreRest();
		if (!nom.isEmpty()) {
			Restaurante rest = restPersist.buscarNomRestPersist(nom);
			if (rest == null) {
				pModificar.mostrarError("No hay ningún restaurante con este nombre.");
				pModificar.activarComponentes(false);
				pModificar.limpiarDatos();

			} else {

				pModificar.cargarDatos(rest);
				pModificar.activarComponentes(true);
				pModificar.ocultarNombre(false);
			}
		} else {
			pModificar.mostrarError("Debe introducir un nombre");
		}

	}

	private void eliminarRest() {

		String rest = pConsulta.eliminarRest();
		if (!rest.equals(null)) {
			restPersist.eliminarRestPersist(rest);

		} else {
			pConsulta.mostrarError("Error al ELIMINAR restaurante.");

		}

	}

	private void registrarRest() {

		Restaurante rest = pRegistrar.registrarRestaurante();

		if (rest != null) {

			int insertRest = restPersist.insertarRestaurante(rest);

			if (insertRest == 1) {

				pRegistrar.mostrarValidacion("Restaurante Añadido correctamente.");
			} else {

				pRegistrar.mostrarError("No se ha podido añadir el restaurante.");

			}
		}

	}

}
