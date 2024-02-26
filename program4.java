package accidentpack;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class program4 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        // C:/Users/Noah/eclipse-workspace/assignment2/src/accidents.csv
    	String csvFilePath = args[0];
    	int minCounters = 0;
    	String state = "CA";
    	String county = "Los Angeles";
    	Queue<Report> reportQueue = new LinkedList<>();
    	

        ReportReader reportReader = new ReportReader(csvFilePath);
        ArrayList<Report> reports = reportReader.readReports();

        //Sorts by start time of the accident
        sort(reports);
        counterCalc(minCounters, state, county, reportQueue, reports);
        
        
        //printFile(reports);
        
    }



	private static void counterCalc(int minCounters, String state, String county, Queue<Report> reportQueue,
	        ArrayList<Report> reports) {
		String tempDate = reports.get(0).getDate();
        
        for (int i = 0; i < reports.size();) {
        	if (reports.get(i).getDate().equals(tempDate)) {
        		i++;
        		if (reports.get(i).getState().equals(state) && reports.get(i).getCounty().equals(county)) {
            		reportQueue.add(reports.get(i));
            	}
        	}
        	else if (!reports.get(i).getDate().equals(tempDate)) {
        		tempDate = reports.get(i).getDate();
        		//process method
        		minCounters = processQueue(minCounters, reportQueue);
        	}
        }
	}



	private static int processQueue(int minCounters, Queue<Report> reportQueue) {
		double totalTime;
		totalTime = 0;
		while (!reportQueue.isEmpty()) {
			Report report = reportQueue.poll();
			if (report.getSeverity() == 1) {
				totalTime = totalTime + 60;
			}
			else if (report.getSeverity() == 2) {
				totalTime = totalTime + 120;
			}
			else if (report.getSeverity() == 3) {
				totalTime = totalTime + 180;
			}
			else {
				totalTime = totalTime + 240;
			}
			
		}
		if (minCounters < totalTime/1440) {
			minCounters = (int) Math.ceil(totalTime/1440);
		}
		return minCounters;
	}



	private static void sort(ArrayList<Report> reports) {
		long startTimer = System.currentTimeMillis();
		Collections.sort(reports, new timeComparator());
		
		long endTimer = System.currentTimeMillis();
        long elapsedTime = (endTimer - startTimer) / 1000;
        System.out.println(elapsedTime + " seconds to sort the file");
        
        System.out.println("Sorted based on start time:");
	}
	
	private static void printFile(ArrayList<Report> reports) {
        for (Report report : reports) {
    		System.out.println("Severity: " + report.getSeverity());
    		System.out.println("Start Time: " + report.getStart_time());
    		System.out.println("Date: " + report.getDate());
    		System.out.println("County: " + report.getCounty());
    		System.out.println("State: " + report.getState());
    		System.out.println("--------------------------------");
        }
	}


		
	
}

	