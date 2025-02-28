package co.edu.poli.ejemplo1.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionConexion {

	private static final Logger LOGGER = Logger.getLogger(GestionConexion.class.getName());
	private static Connection conexion;
	private static final Properties propiedades = new Properties();

	private GestionConexion() {
	}

	private static void cargarPropiedades() {
		if (propiedades.isEmpty()) {
			try (InputStream input = GestionConexion.class.getClassLoader().getResourceAsStream("database.properties")) {
				if (input == null) {
					throw new IOException("El archivo database.properties no se encontró en el classpath.");
				}
				propiedades.load(input);
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "Error al cargar las propiedades de conexión", e);
			}
		}
	}

	/**
	 * Obtiene una conexión a la base de datos.
	 *
	 * @return La conexión a la base de datos.
	 * @throws SQLException Si ocurre un error al conectar a la base de datos.
	 */
	public static synchronized Connection obtenerConexion() throws SQLException {
		if (conexion == null || esConexionCerrada()) {
			cargarPropiedades();
			try {
				String URL = propiedades.getProperty("db.url");
				String USUARIO = propiedades.getProperty("db.user");
				String CONTRASEÑA = propiedades.getProperty("db.password");

				conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
				LOGGER.info("Conexión a la base de datos establecida.");
			} catch (SQLException e) {
				LOGGER.log(Level.SEVERE, "Error al conectar a la base de datos", e);
				throw new SQLException("Error al conectar con la base de datos: " + e.getMessage(), e);
			}
		}
		return conexion;
	}

	private static boolean esConexionCerrada() {
		try {
			return conexion == null || conexion.isClosed();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Error al verificar la conexión", e);
			return true;
		}
	}

	public static void cerrarConexion() {
		if (conexion != null) {
			try (Connection conn = conexion) {
				conexion = null;
				LOGGER.info("Conexión cerrada correctamente.");
			} catch (SQLException e) {
				LOGGER.log(Level.SEVERE, "Error al cerrar la conexión", e);
			}
		}
	}
}