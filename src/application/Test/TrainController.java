package application.Test;

import application.TrackModel.TrackModelSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TrainController {

	@FXML
	private TextField displaceTrainID;

	@FXML
	private TextField displaceAmount;

	@FXML
	private TextField dockTrainID;

	@FXML
	private TextField dockPassengers;

	@FXML
	private TextField dockCapacity;

	@FXML
	void displaceTrain(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			int trainID = Integer.parseInt(displaceTrainID.getText());
			double displacement = Double.parseDouble(displaceAmount.getText());
			mySin.updateTrainDisplacement(trainID, displacement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void exchangePassengers(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			int trainID = Integer.parseInt(dockTrainID.getText());
			int currentPassengers = Integer.parseInt(dockPassengers.getText());
			int capacity = Integer.parseInt(dockCapacity.getText());
			mySin.stationPassengerExchange(trainID, currentPassengers, capacity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
