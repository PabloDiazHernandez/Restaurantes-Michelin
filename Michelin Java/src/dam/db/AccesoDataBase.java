package dam.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AccesoDataBase {

	private String driver;
	private String url;

	public AccesoDataBase() {

		Properties prop = new Properties();
		InputStream entrada = null;

		try {
			entrada = new FileInputStream("ConfiguracionDB.properties");
			prop.load(entrada);
			driver = prop.getProperty("DRIVER");
			url = prop.getProperty("URL");

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}

	}

	public Connection getConexion() throws ClassNotFoundException, SQLException {

		Class.forName(driver);

		Connection con = DriverManager.getConnection(url);

		return con;

	}

}
