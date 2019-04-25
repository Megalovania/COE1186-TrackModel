package application.Test;

import application.TrackModel.TrackModelSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CTCController {

    @FXML
    private TextField lineName;

    @FXML
    private TextField stationName;

    @FXML
    private Label totalBoarders;

    @FXML
    private Label scheduledBoarders;

    @FXML
    private Label scheduledAlighters;

    @FXML
    void getLineBoarders(ActionEvent event) {
    	try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			int boarders = mySin.getTotalBoarders(lineName.getText());
			totalBoarders.setText(Integer.toString(boarders));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void getTicketSales(ActionEvent event) {
    	try {
			TrackModelSingleton mySin = TrackModelSingleton.getInstance();
			scheduledBoarders.setText(Integer.toString(mySin.getScheduledBoarding(lineName.getText(), stationName.getText())));
			scheduledAlighters.setText(Integer.toString(mySin.getScheduledAlighting(lineName.getText(), stationName.getText())));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
