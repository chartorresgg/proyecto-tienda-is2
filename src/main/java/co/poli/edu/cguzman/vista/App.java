package co.poli.edu.cguzman.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;

/**
 * JavaFX App
 */
public class App extends Application {

	/*
	 * En este caso, la clase App es la clase principal de la aplicación y extiende
	 * de Application,
	 */

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {

		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/co/poli/edu/cguzman/vista/formulario.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Formulario de Cliente");
		stage.show();
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

}