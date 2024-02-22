package accidentpack;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class program4 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        // C:/Users/Noah/eclipse-workspace/assignment2/src/accidents.csv
    	String csvFilePath = args[0];
    	int totalTime;
    	int maxCounters;

        ReportReader reportReader = new ReportReader(csvFilePath);
        ArrayList<Report> reports = reportReader.readReports();
   
        //Sorts by start time of the accident
        sort(reports);
        
    }

	private static void sort(ArrayList<Report> reports) {
		long startTimer = System.currentTimeMillis();
		Collections.sort(reports, new timeComparator());
		
		long endTimer = System.currentTimeMillis();
        long elapsedTime = (endTimer - startTimer) / 1000;
        System.out.println(elapsedTime + " seconds to sort the file");
        
        System.out.println("Sorted based on start time:");
	}


		
	
}

	