module co.poli.edu.cguzman {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;

	opens co.poli.edu.cguzman.vista to javafx.fxml;
	opens co.poli.edu.cguzman.controlador to javafx.fxml;

	exports co.poli.edu.cguzman.vista;
	exports co.poli.edu.cguzman.controlador;
}
