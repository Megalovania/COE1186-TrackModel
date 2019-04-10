package application.Test;

import application.TrackModel.SwitchStateException;
import application.TrackModel.TrackModelSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class TrackController {

	@FXML
	private TextField dispatchTrain;

	@FXML
	private TextField dispatchLine;

	@FXML
	private TextField switchLine;

	@FXML
	private TextField switchID;

	@FXML
	private TextField switchState;

	@FXML
	void createTrain(ActionEvent event) {

		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			String lineName = dispatchLine.getText();
			int trainID = Integer.parseInt(dispatchTrain.getText());
			mySin.createTrain(lineName, trainID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void setSwitch(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			String lineName = switchLine.getText();
			int switchy = Integer.parseInt(switchID.getText());
			int state = Integer.parseInt(switchState.getText());
			boolean straight;
			if (state == 0)
				straight = true;
			else
				straight = false;

			mySin.setSwitch(lineName, switchy, straight);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
