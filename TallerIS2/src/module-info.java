module TallerIS2 {
	requires javafx.controls;
	requires java.sql;
	
	opens co.edu.poli.ejemplo1.view to javafx.graphics, javafx.fxml;
}