package dam.db.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dam.db.AccesoDataBase;
import dam.model.Restaurante;
import dam.view.PRegistrarRestaurante;

public class RestaurantePersistencia {

	private AccesoDataBase acceso;

	public RestaurantePersistencia() {
		acceso = new AccesoDataBase();
	}

	public ArrayList<Restaurante> ConsultarRestDist(String distincion) {

		ArrayList<Restaurante> restaurante = new ArrayList<Restaurante>();

		String querie = " SELECT " + RestauranteContract.COL_NOMBRE + ", " + RestauranteContract.COL_CIUDAD + ", "
				+ RestauranteContract.COL_DISTINCION + ", " + RestauranteContract.COL_COCINA + ", "
				+ RestauranteContract.COL_PRECIO_MIN + ", " + RestauranteContract.COL_PRECIO_MAX + " FROM "
				+ RestauranteContract.TAB_RESTAURANTES + " WHERE " + RestauranteContract.COL_DISTINCION + " = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;

		try {
			String ciudad;
			String nomRest;
			String cocina;

			double precio_max = 0;
			double precio_min = 0;
			String val = "";

			con = acceso.getConexion();
			pstmt = con.prepareStatement(querie);
			pstmt.setString(1, distincion);
			rslt = pstmt.executeQuery();

			while (rslt.next()) {

				nomRest = rslt.getString(1);
				ciudad = rslt.getString(2);
				distincion = rslt.getString(3);
				cocina = rslt.getString(4);
				precio_min = rslt.getDouble(5);
				precio_max = rslt.getDouble(6);
				val = Double.toString(precio_min);
				val += " - ";
				val += Double.toString(precio_max);
				restaurante.add(new Restaurante(nomRest, ciudad, distincion, cocina, val));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rslt != null)
					rslt.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return restaurante;

	}

	public ArrayList<Restaurante> ConsultarRestReg_distin(String region, String distin) {

		ArrayList<Restaurante> restaurante = new ArrayList<Restaurante>();

		String querie = " SELECT " + RestauranteContract.COL_NOMBRE + ", " + RestauranteContract.COL_CIUDAD + ", "
				+ RestauranteContract.COL_DISTINCION + ", " + RestauranteContract.COL_COCINA + ", "
				+ RestauranteContract.COL_PRECIO_MIN + ", " + RestauranteContract.COL_PRECIO_MAX + " FROM "
				+ RestauranteContract.TAB_RESTAURANTES + " WHERE " + RestauranteContract.COL_REGION + " = ?  AND "
				+ RestauranteContract.COL_DISTINCION + " =?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;

		try {
			String ciudad;
			String nomRest;
			String distincion;
			String cocina;
			double precio_max = 0;
			double precio_min = 0;
			String val = "";

			con = acceso.getConexion();
			pstmt = con.prepareStatement(querie);
			pstmt.setString(1, region);
			pstmt.setString(2, distin);

			rslt = pstmt.executeQuery();

			while (rslt.next()) {

				nomRest = rslt.getString(1);
				ciudad = rslt.getString(2);
				distincion = rslt.getString(3);
				cocina = rslt.getString(4);
				precio_min = rslt.getDouble(5);
				precio_max = rslt.getDouble(6);
				val = Double.toString(precio_min);
				val += " - ";
				val += Double.toString(precio_max);
				restaurante.add(new Restaurante(nomRest, ciudad, distincion, cocina, val));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rslt != null)
					rslt.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return restaurante;

	}

	public ArrayList<Restaurante> ConsultarRestRegion(String region) {

		ArrayList<Restaurante> restaurante = new ArrayList<Restaurante>();

		String querie = " SELECT " + RestauranteContract.COL_NOMBRE + ", " + RestauranteContract.COL_CIUDAD + ", "
				+ RestauranteContract.COL_DISTINCION + ", " + RestauranteContract.COL_COCINA + ", "
				+ RestauranteContract.COL_PRECIO_MIN + ", " + RestauranteContract.COL_PRECIO_MAX + " FROM "
				+ RestauranteContract.TAB_RESTAURANTES + " WHERE " + RestauranteContract.COL_REGION + " = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;

		try {
			String ciudad;
			String nomRest;
			String distincion;
			String cocina;
			double precio_max = 0;
			double precio_min = 0;
			String val = "";

			con = acceso.getConexion();
			pstmt = con.prepareStatement(querie);
			pstmt.setString(1, region);
			rslt = pstmt.executeQuery();

			while (rslt.next()) {

				nomRest = rslt.getString(1);
				ciudad = rslt.getString(2);
				distincion = rslt.getString(3);
				cocina = rslt.getString(4);
				precio_min = rslt.getDouble(5);
				precio_max = rslt.getDouble(6);
				val = Double.toString(precio_min);
				val += " - ";
				val += Double.toString(precio_max);
				restaurante.add(new Restaurante(nomRest, ciudad, distincion, cocina, val));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rslt != null)
					rslt.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return restaurante;

	}

	public ArrayList<String> obtenerRegiones() {
		ArrayList<String> listRegion = new ArrayList<>();
		String querie = "SELECT  DISTINCT " + RestauranteContract.COL_REGION + " FROM "
				+ RestauranteContract.TAB_RESTAURANTES;

		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;

		String region = "";

		try {
			con = acceso.getConexion();
			stmt = con.createStatement();
			rslt = stmt.executeQuery(querie);

			while (rslt.next()) {

				region = rslt.getString(1);
				listRegion.add(region);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null)
					rslt.close();

				if (stmt != null)
					stmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return listRegion;
	}

	public ArrayList<Restaurante> ListadoRest() {

		ArrayList<Restaurante> restaurante = new ArrayList<Restaurante>();

		String querie = " SELECT " + RestauranteContract.COL_NOMBRE + ", " + RestauranteContract.COL_CIUDAD + ", "
				+ RestauranteContract.COL_DISTINCION + ", " + RestauranteContract.COL_COCINA + ", "
				+ RestauranteContract.COL_PRECIO_MIN + ", " + RestauranteContract.COL_PRECIO_MAX + " FROM "
				+ RestauranteContract.TAB_RESTAURANTES;
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;

		try {
			String ciudad;
			String nomRest;
			String cocina;
			String distincion;
			double precio_max = 0;
			double precio_min = 0;
			String val = "";

			con = acceso.getConexion();
			stmt = con.createStatement();
			rslt = stmt.executeQuery(querie);

			while (rslt.next()) {

				nomRest = rslt.getString(RestauranteContract.COL_NOMBRE);
				ciudad = rslt.getString(RestauranteContract.COL_CIUDAD);
				distincion = rslt.getString(RestauranteContract.COL_DISTINCION);
				cocina = rslt.getString(RestauranteContract.COL_COCINA);
				precio_min = rslt.getDouble(RestauranteContract.COL_PRECIO_MIN);
				precio_max = rslt.getDouble(RestauranteContract.COL_PRECIO_MAX);
				val = Double.toString(precio_min);
				val += " - ";
				val += Double.toString(precio_max);
				restaurante.add(new Restaurante(nomRest, ciudad, distincion, cocina, val));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rslt != null)
					rslt.close();

				if (stmt != null)
					stmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return restaurante;

	}

	public Restaurante buscarNomRestPersist(String nombre) {
		Restaurante rest = null;
		String querie = " SELECT " + RestauranteContract.COL_NOMBRE + ", " + RestauranteContract.COL_REGION + ", "
				+ RestauranteContract.COL_CIUDAD + ", " + RestauranteContract.COL_DISTINCION + ","
				+ RestauranteContract.COL_DIRECCION + ", " + RestauranteContract.COL_PRECIO_MIN + ", "
				+ RestauranteContract.COL_PRECIO_MAX + ", " + RestauranteContract.COL_COCINA + ", "
				+ RestauranteContract.COL_TELEFONO + ", " + RestauranteContract.COL_WEB + " FROM "
				+ RestauranteContract.TAB_RESTAURANTES + " WHERE " + RestauranteContract.COL_NOMBRE + " LIKE ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;

		String ciudad;
		String nomRest;
		String cocina;
		int distincion;
		String direccion;
		double precio_min;
		double precio_max;
		String region;
		String telefono;
		String web;
		try {
			con = acceso.getConexion();
			pstmt = con.prepareStatement(querie);
			pstmt.setString(1, "%" + nombre + "%");
			rslt = pstmt.executeQuery();

			if (rslt.next()) {

				nomRest = rslt.getString(RestauranteContract.COL_NOMBRE);
				ciudad = rslt.getString(RestauranteContract.COL_CIUDAD);
				region = rslt.getString(RestauranteContract.COL_REGION);
				direccion = rslt.getString(RestauranteContract.COL_DIRECCION);
				distincion = rslt.getInt(RestauranteContract.COL_DISTINCION);
				cocina = rslt.getString(RestauranteContract.COL_COCINA);
				precio_min = rslt.getDouble(RestauranteContract.COL_PRECIO_MIN);
				precio_max = rslt.getDouble(RestauranteContract.COL_PRECIO_MAX);
				telefono = rslt.getString(RestauranteContract.COL_TELEFONO);
				web = rslt.getString(RestauranteContract.COL_WEB);

				rest = new Restaurante(nomRest, ciudad, direccion, distincion, region, cocina, precio_max, precio_min,
						telefono, web);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null)
					rslt.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return rest;

	}

	public void eliminarRestPersist(String nombre) {

		String querie = " DELETE  FROM " + RestauranteContract.TAB_RESTAURANTES + " WHERE "
				+ RestauranteContract.COL_NOMBRE + " = ? ";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = acceso.getConexion();

			pstmt = con.prepareStatement(querie);
			pstmt.setString(1, nombre);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public int modificarRestaurante(Restaurante rest) {

		int resultado = 0;

		String querie = "UPDATE " + RestauranteContract.TAB_RESTAURANTES 
				+ " SET " + RestauranteContract.COL_REGION + "=?, " 
				+ RestauranteContract.COL_CIUDAD + "=?, " 
				+ RestauranteContract.COL_DISTINCION + "=?,"
				+ RestauranteContract.COL_DIRECCION + "=?, " 
				+ RestauranteContract.COL_PRECIO_MIN + "=?, "
				+ RestauranteContract.COL_PRECIO_MAX + "=?, " 
				+ RestauranteContract.COL_COCINA + "=?, "
				+ RestauranteContract.COL_TELEFONO + "=?, " 
				+ RestauranteContract.COL_WEB + " =? "
				+ " WHERE " + RestauranteContract.COL_NOMBRE + " =? ";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = acceso.getConexion();
			pstmt = con.prepareStatement(querie);

			// pstmt.setString(1, rest.getNombre());
			pstmt.setString(1, rest.getRegion());
			pstmt.setString(2, rest.getCiudad());
			pstmt.setInt(3, rest.getDistint());
			pstmt.setString(4, rest.getDireccion());
			pstmt.setDouble(5, rest.getPrecio_min());
			pstmt.setDouble(6, rest.getPrecio_max());
			pstmt.setString(7, rest.getCocina());
			pstmt.setString(8, rest.getTelefono());
			pstmt.setString(9, rest.getWeb());
			pstmt.setString(10, rest.getNombre());
			resultado = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

		} catch (SQLException e) {

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {

				// e.printStackTrace();
			}

		}

		return resultado;

	}

	public int insertarRestaurante(Restaurante rest) {

		int resultado = 0;
		PRegistrarRestaurante pr = new PRegistrarRestaurante();

		String querie = "INSERT INTO " + RestauranteContract.TAB_RESTAURANTES + " (" + RestauranteContract.COL_ID + ", "
				+ RestauranteContract.COL_NOMBRE + ", " + RestauranteContract.COL_REGION + ", "
				+ RestauranteContract.COL_CIUDAD + ", " + RestauranteContract.COL_DISTINCION + ","
				+ RestauranteContract.COL_DIRECCION + ", " + RestauranteContract.COL_PRECIO_MIN + ", "
				+ RestauranteContract.COL_PRECIO_MAX + ", " + RestauranteContract.COL_COCINA + ", "
				+ RestauranteContract.COL_TELEFONO + ", " + RestauranteContract.COL_WEB
				+ ")  VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = acceso.getConexion();

			pstmt = con.prepareStatement(querie);
			// pstmt.setInt(1, rest.getId());
			pstmt.setString(2, rest.getNombre());
			pstmt.setString(3, rest.getRegion());
			pstmt.setString(4, rest.getCiudad());
			pstmt.setInt(5, rest.getDistint());
			pstmt.setString(6, rest.getDireccion());
			pstmt.setDouble(7, rest.getPrecio_min());
			pstmt.setDouble(8, rest.getPrecio_max());
			pstmt.setString(9, rest.getCocina());
			pstmt.setString(10, rest.getTelefono());
			pstmt.setString(11, rest.getWeb());
			resultado = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

		} catch (SQLException e) {
			pr.mostrarError(" Ya existe un restaurante con este nombre. ");

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {

				// e.printStackTrace();
			}

		}

		return resultado;

	}

}
