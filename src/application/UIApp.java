package application;

import java.util.concurrent.CountDownLatch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//WARNING: You MUST run this program from Main.java, 
//	otherwise the Singleton's won't talk to each other
public class UIApp extends Application {

	//NOTE: Use this to disable update methods for other modules
		// Each number corresponds to a module below.
	private static boolean ENABLE_1 = true;
	private static boolean ENABLE_2 = true;
	private static boolean ENABLE_3 = true;
	private static boolean ENABLE_4 = true;
	private static boolean ENABLE_5 = true;
	private static boolean ENABLE_6 = true;
	
	
	public static final CountDownLatch latch = new CountDownLatch(1);
	public static UIApp uiApp = null;

	@Override
	public void start(Stage ctcStage) {
		try {

			

			// Root for Track Model
			//Stage tckModStage = new Stage();
			Parent tckModRoot = FXMLLoader.load(getClass().getResource("./TrackModel/TrackModel.fxml"));
			ctcStage.setTitle("Track Model");
			Scene tckModScene = new Scene(tckModRoot, 1100, 620); // NOTE: Change last two ints to make window bigger
			ctcStage.setScene(tckModScene);
			if(ENABLE_3) ctcStage.show();
			
			Stage test1Stage = new Stage();
			Parent test1Root = FXMLLoader.load(getClass().getResource("./Test/TrackController.fxml"));
			test1Stage.setTitle("Test Track Controller");
			Scene test1Scene = new Scene(test1Root, 650, 450); // NOTE: Change last two ints to make window bigger
			test1Stage.setScene(test1Scene);
			if(ENABLE_3) test1Stage.show();
			
			Stage test2Stage = new Stage();
			Parent test2Root = FXMLLoader.load(getClass().getResource("./Test/TrainModel.fxml"));
			test2Stage.setTitle("Test Train Controller");
			Scene test2Scene = new Scene(test2Root, 650, 450); // NOTE: Change last two ints to make window bigger
			test2Stage.setScene(test2Scene);
			if(ENABLE_3) test2Stage.show();
			


			// If we have time, we'll start adding styles using the line below
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static UIApp waitForUITest() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return uiApp;
	}

	public static void setUITest(UIApp uiTest0) {
		uiApp = uiTest0;
		latch.countDown();
	}

	public UIApp() {
		setUITest(this);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
