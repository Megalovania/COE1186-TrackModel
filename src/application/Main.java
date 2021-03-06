package application;

import application.TrackModel.TrackModelSingleton;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// WARNING: You MUST run this program from Main.java, 
// 		otherwise the Singleton's won't talk to each other
public class Main {

	//NOTE: Set True to Debug Update Methods
	private static boolean DEBUG = true;	
	
	//NOTE: Use this to disable update methods for other modules
		// Each number corresponds to a module below.
	private static boolean ENABLE_1 = true;
	private static boolean ENABLE_2 = true;
	private static boolean ENABLE_3 = true;
	private static boolean ENABLE_4 = true;
	private static boolean ENABLE_5 = true;
	private static boolean ENABLE_6 = true;
	
	
	
	private static boolean printedUpdateDebugs = false;	// ensures 1 print for update methods
	
	public static void main(String[] args) {
		// Singleton References
		TrackModelSingleton 		tckModSin = 	TrackModelSingleton.getInstance();
		
		ClockSingleton clock = ClockSingleton.getInstance();


		// Calling Thread which starts the FX UI
		new Thread() {
			@Override
			public void run() {
				javafx.application.Application.launch(UIApp.class);
			}
		}.start();
		UIApp.waitForUITest();

		// Scheduler which tells the singleton's to update
		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				update(tckModSin, clock);
			}
		}, 0, 1, TimeUnit.SECONDS); // Determines update frequency (1 sec atm)

	}

	// calls each singleton's update() method
	private static void update(TrackModelSingleton tckModSin, ClockSingleton clock) {
		// call singleton update methods
		
		if(DEBUG && !printedUpdateDebugs && !(ENABLE_1 && ENABLE_2 && ENABLE_3 && ENABLE_4 && ENABLE_5 && ENABLE_6) ) System.err.println("WARNING: Some updates Have been disabled");
		
		try {
			if(DEBUG && !printedUpdateDebugs) System.out.println("DEBUG: 0 - Scheduler worked");
			
			
			if(ENABLE_3) tckModSin.update();
			if(DEBUG && !printedUpdateDebugs) System.out.println("DEBUG: 3 - Track Model update worked");
			
			clock.update();
		} catch (Exception e) {
			System.err.println();
			StackTraceElement[] elements = e.getStackTrace();  
            for (int iterator=1; iterator<=elements.length; iterator++)  
                   System.err.println("Class Name:"+elements[iterator-1].getClassName()+" Method Name:"+elements[iterator-1].getMethodName()+" Line Number:"+elements[iterator-1].getLineNumber());
		}
		
		printedUpdateDebugs = true;
	}
}
