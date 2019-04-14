package application.Test;

import java.text.DecimalFormat;

import application.TrackModel.TrackCircuitFailureException;
import application.TrackModel.TrackModelSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;

public class TrainController {

	@FXML
	private TextField trainID;

	@FXML
	private TextField amount;

	@FXML
	private TextField capacity;

	@FXML
	private Label yCoord;

	@FXML
	private Label length;

	@FXML
	private Label grade;

	@FXML
	private Label speedLimit;

	@FXML
	private Label elevation;

	@FXML
	private Label isStation;

	@FXML
	private Label xCoord;

	@FXML
	private Label beaconData;

	@FXML
	private Label underground;

	@FXML
	private Label hasLight;

	@FXML
	private Label lightColor;

	@FXML
	private Label suggestedSpeed;

	@FXML
	private Label authority;

	@FXML
	private Label hasPower;

	@FXML
	void displaceTrain(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			int train = Integer.parseInt(trainID.getText());
			double displacement = Double.parseDouble(amount.getText());
			mySin.updateTrainDisplacement(train, displacement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void exchangePassengers(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			int train = Integer.parseInt(trainID.getText());
			int currentPassengers = Integer.parseInt(amount.getText());
			int capacityNum = Integer.parseInt(capacity.getText());
			mySin.stationPassengerExchange(train, currentPassengers, capacityNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void getData(ActionEvent event) {
		try {
			DecimalFormat df1 = new DecimalFormat("#.##");

			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			int train = Integer.parseInt(trainID.getText());

			xCoord.setText(df1.format(mySin.getTrainXCoordinate(train)));
			yCoord.setText(df1.format(mySin.getTrainYCoordinate(train)));

			length.setText(df1.format(mySin.getTrainBlockLength(train)));
			grade.setText(df1.format(mySin.getTrainBlockGrade(train)));
			speedLimit.setText(df1.format(mySin.getTrainBlockSpeedLimit(train)));
			elevation.setText(df1.format(mySin.getTrainBlockElevation(train)));

			if (mySin.trainBlockIsUnderground(train)) {
				underground.setText("Yep");
			} else {
				underground.setText("Nope");
			}

			try {
				suggestedSpeed.setText(df1.format(mySin.getTrainSuggestedSpeed(train)));
				authority.setText(Integer.toString(mySin.getTrainBlockAuthority(train)));
			} catch (TrackCircuitFailureException e) {
				suggestedSpeed.setText("Track Circuit Failure");
				authority.setText("Track Circuit Failure");
			}

			if (mySin.trainHasPower(train)) {
				hasPower.setText("Yep");
			} else {
				hasPower.setText("Nope");
			}

			if (mySin.trainBlockIsStation(train)) {
				isStation.setText("Yep");
				beaconData.setText(mySin.getTrainBlockBeaconData(train));
			} else {
				isStation.setText("Nope");
				beaconData.setText("--");
			}

			if (mySin.trainBlockHasLight(train)) {
				hasLight.setText("Yep");
				if (mySin.trainBlockLightIsGreen(train)) {
					lightColor.setText("green");
				} else {
					lightColor.setText("red");
				}
			} else {
				hasLight.setText("Nope");
				lightColor.setText("--");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
