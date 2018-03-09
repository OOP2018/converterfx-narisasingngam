package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
	@FXML
	ComboBox<Length> box1;
	@FXML
	ComboBox<Length> box2;

	/**
	 * Convert a distance from one unit to another.
	 */
	public void handleConvert(ActionEvent event) {
		textfield1.setStyle("-fx-text-inner-color: black;");
		String text = textfield1.getText().trim();
		double b1 = box1.getValue().getValue();
		double b2 = box2.getValue().getValue();
		try {
			if (!text.equals("")) {
				double d = Double.parseDouble(text);
				System.out.println("handleConvert converting " + text);
				textfield2.setText(String.format("%.4g", (d*b1)/b2));

			} else {
				double d = Double.parseDouble(textfield2.getText());
				textfield1.setText(String.format("%.4g", (d*b2)/b1));
			}

		} catch (NumberFormatException ex) {
			textfield2.setText("Invalid");
			textfield1.setStyle("-fx-text-inner-color: red;");

		}

	}

	/**
	 * JavaFX calls the initialize() method of your controller when it creates
	 * the UI form, after the components have been created and @FXML annotated
	 * attributes have been set.
	 *
	 * This is a hook to initialize anything your controller or UI needs.
	 */
	@FXML
	public void initialize() {
		// This is for testing
		System.out.println("Running initialize");
		if (box1 != null) {
			box1.getItems().addAll(Length.values());
			box1.getSelectionModel().select(0); // select an item to show
		}
		if (box2 != null) {
			box2.getItems().addAll(Length.values());
			box2.getSelectionModel().select(1); // select an item to show
		}
	}

	public void handleClear(ActionEvent event) {
		textfield1.setStyle("-fx-text-inner-color: black;");
		textfield1.setText("");
		textfield2.setText("");
	}

}
