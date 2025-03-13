package co.poli.edu.cguzman.controlador;

import co.poli.edu.cguzman.modelo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorFormulario {

	@FXML
	private Button btn_guardar;

	@FXML
	private TextField txt_id;

	@FXML
	private TextField txt_nombres;

	Cliente objetocliente;
	
	@FXML
	private void click(ActionEvent event) {
		
		objetocliente = new Cliente(txt_id.getText(), txt_nombres.getText());
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setContentText(objetocliente.toString());
    	alert.show();
		
	}

}