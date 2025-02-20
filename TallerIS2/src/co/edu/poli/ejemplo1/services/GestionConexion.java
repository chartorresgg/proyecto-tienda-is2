package co.edu.poli.ejemplo1.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GestionConexion {

	private static Connection conexion;
	private static String mensajeError;

	private GestionConexion() {
	}

	public static Connection obtenerConexion() {
		if (conexion == null) {
			try {
				Properties propiedades = new Properties();
				FileInputStream entrada = new FileInputStream("config/database.properties");
				propiedades.load(entrada);

				String URL = propiedades.getProperty("db.url");
				String USUARIO = propiedades.getProperty("db.user");
				String CONTRASEÑA = propiedades.getProperty("db.password");

				conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
				mensajeError = "Conexión a la base de datos establecida.";

			} catch (IOException e) {
				mensajeError = "Error al leer el archivo de propiedades: " + e.getMessage();
			} catch (SQLException e) {
				mensajeError = "Error al conectar con la base de datos: " + e.getMessage();
			}
		} else {
			try {
				if (conexion.isClosed()) {
					Properties propiedades = new Properties();
					FileInputStream entrada = new FileInputStream("config/database.properties");
					propiedades.load(entrada);

					String URL = propiedades.getProperty("db.url");
					String USUARIO = propiedades.getProperty("db.user");
					String CONTRASEÑA = propiedades.getProperty("db.password");

					conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
					mensajeError = "Conexión a la base de datos restablecida.";
				}
			} catch (SQLException | IOException e) {
				mensajeError = "Error al verificar o restablecer la conexión: " + e.getMessage();
			}
		}
		return conexion;
	}

	public Connection getConnection() {
		return conexion;
	}

	public static void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;
				mensajeError = "Conexión cerrada correctamente.";
			} catch (SQLException e) {
				mensajeError = "Error al cerrar la conexión: " + e.getMessage();
			}
		}
	}

	public static String getMensajeError() {
		return mensajeError;
	}
}