package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameDisplayController {
	@FXML
	Button actionButton1;
	@FXML
	Button actionButton2;

	public void setActionButton1Text(String text) {
		actionButton1.setText(text);
	}
	
	public void setActionButton2Text(String text) {
		actionButton2.setText(text);
	}
}
