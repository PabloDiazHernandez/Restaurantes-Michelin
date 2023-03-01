package dam.main;

import java.awt.EventQueue;

import dam.control.RestauranteControl;
import dam.view.PConsultaRestaurante;
import dam.view.PRegistrarRestaurante;
import dam.view.PModificarRestaurante;
import dam.view.VPrincipal;

public class InicioGuiaRestaurantes {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				PConsultaRestaurante pc = new PConsultaRestaurante();
				PRegistrarRestaurante pr = new PRegistrarRestaurante();
				PModificarRestaurante pm = new PModificarRestaurante();
				VPrincipal vp = new VPrincipal();

				RestauranteControl rc = new RestauranteControl(pc, pr, pm, vp);
				vp.setControlador(rc);
				pc.setControlador(rc);
				pr.setControlador(rc);
				pm.setControlador(rc);

				vp.hacerVisible();
				pc.hacerVisible();
				pr.hacerVisible();
				pm.hacerVisible();

			}
		});

	}

}
