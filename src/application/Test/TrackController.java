package application.Test;

import application.TrackModel.TrackCircuitFailureException;
import application.TrackModel.TrackModelSingleton;
import application.TrackModel.TrackPowerFailureException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;

public class TrackController {

	@FXML
	private TextField lineName;

	@FXML
	private TextField ID;

	@FXML
	private TextField value;

	@FXML
	private Label occupancy;

	@FXML
	void createTrain(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			String line = lineName.getText();
			int trainID = Integer.parseInt(ID.getText());
			mySin.createTrain(line, trainID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void getBlockOccupancy(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			String line = lineName.getText();
			int blockID = Integer.parseInt(ID.getText());

			boolean occ = mySin.getOccupancy(line, blockID);
			if (occ)
				occupancy.setText("Yep");
			else
				occupancy.setText("Nope");

		} catch (TrackCircuitFailureException ex) {
			occupancy.setText("Track Circuit Broken (Oc)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void setAuthority(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			String line = lineName.getText();
			int blockID = Integer.parseInt(ID.getText());
			int auth = Integer.parseInt(value.getText());

			mySin.setAuthority(line, blockID, auth);
		} catch (TrackCircuitFailureException ex) {
			occupancy.setText("Track Circuit Broken (Au)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void setCrossingOn(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			String line = lineName.getText();
			int blockID = Integer.parseInt(ID.getText());
			int state = Integer.parseInt(value.getText());
			boolean crossingOn;
			if (state == 0)
				crossingOn = false;
			else
				crossingOn = true;

			mySin.setCrossing(line, blockID, crossingOn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void setCtrlAuthority(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			String line = lineName.getText();
			int blockID = Integer.parseInt(ID.getText());
			int state = Integer.parseInt(value.getText());
			boolean ctrlAuth;
			if (state == 0)
				ctrlAuth = false;
			else
				ctrlAuth = true;

			mySin.setControlAuthority(line, blockID, ctrlAuth);
		} catch (TrackCircuitFailureException ex) {
			occupancy.setText("Track Circuit Broken (CA)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void setLightGreen(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			String line = lineName.getText();
			int blockID = Integer.parseInt(ID.getText());
			int state = Integer.parseInt(value.getText());
			boolean lightGreen;
			if (state == 0)
				lightGreen = false;
			else
				lightGreen = true;

			mySin.setLightStatus(line, blockID, lightGreen);
		} catch (TrackPowerFailureException e) {
			occupancy.setText("Light has no Power");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void setSpeed(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			String line = lineName.getText();
			int blockID = Integer.parseInt(ID.getText());
			int speed = Integer.parseInt(value.getText());

			mySin.setSuggestedSpeed(line, blockID, (int) speed);
		} catch (TrackCircuitFailureException ex) {
			occupancy.setText("Track Circuit Broken (Sp)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void setSwitchStraight(ActionEvent event) {
		try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			String line = lineName.getText();
			int switchID = Integer.parseInt(ID.getText());
			int state = Integer.parseInt(value.getText());
			boolean straight;
			if (state == 0)
				straight = false;
			else
				straight = true;

			mySin.setSwitch(line, switchID, straight);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
