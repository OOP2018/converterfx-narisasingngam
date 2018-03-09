package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * UI controller for events and initializing components.
 *
 */
public class ConverterController {
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;

	/**
	 * Convert a distance from one unit to another.
	 */
	public void handleConvert(ActionEvent event) {
		textfield1.setStyle("-fx-text-inner-color: black;");
		String text = textfield1.getText().trim();
		try {
			double d = Double.parseDouble(text);
			System.out.println("handleConvert converting " + text);
			textfield2.setText(String.format("%f", d*1.609344));
			

		} catch (NumberFormatException ex) {
			textfield2.setText("Invalid");
			textfield1.setStyle("-fx-text-inner-color: red;");

		}

	}

	public void handleClear(ActionEvent event) {
		
	}

}
