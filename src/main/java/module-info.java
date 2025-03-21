module co.poli.edu.cguzman {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires java.sql;
	requires javafx.base;

	opens co.poli.edu.cguzman.vista to javafx.fxml;
	opens co.poli.edu.cguzman.controlador to javafx.fxml;
	opens co.poli.edu.cguzman.modelo to javafx.base;

	exports co.poli.edu.cguzman.vista;
	exports co.poli.edu.cguzman.controlador;
}
