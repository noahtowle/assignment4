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
    	Queue<Report> reportQueue = new LinkedList<>();
    	

        ReportReader reportReader = new ReportReader(csvFilePath);
        ArrayList<Report> reports = reportReader.readReports();

        //Sorts by start time of the accident
        sort(reports);
        
        //Outputs data based on the specified state/county combination
        printOutput(minCounters, reportQueue, reports);
        
        //printFile(reports);
        
    }



	private static void printOutput(int minCounters, Queue<Report> reportQueue, ArrayList<Report> reports) {
		String state = "CA";
    	String county = "Los Angeles";
		//prints the data with given state/county input
        outputData(minCounters, state, county, reportQueue, reports);
        state = "FL";
        county = "Orange";
        outputData(minCounters, state, county, reportQueue, reports);
        state = "TX";
        county = "Harris";
        outputData(minCounters, state, county, reportQueue, reports);
        state = "OH";
        county = "Hamilton";
        outputData(minCounters, state, county, reportQueue, reports);
        state = "DE";
        county = "New Castle";
        outputData(minCounters, state, county, reportQueue, reports);
	}



	private static void outputData(int minCounters, String state, String county, Queue<Report> reportQueue,
	        ArrayList<Report> reports) {
		System.out.println("County: " + county);
        System.out.println("State: " + state);
		long startTimer = System.currentTimeMillis();
        minCounters = counterCalc(minCounters, state, county, reportQueue, reports);
        long endTimer = System.currentTimeMillis();
        long elapsedTime = (endTimer - startTimer);
        System.out.println(elapsedTime + " milliseconds to simulate the process");
        System.out.println("Minimum number of counters: " + minCounters);
        System.out.println("--------------------------------");
	}



	private static int counterCalc(int minCounters, String state, String county, Queue<Report> reportQueue,
	        ArrayList<Report> reports) {
		String tempDate = reports.get(0).getDate();
        
		//Adds to queue based on county and state provided, only iterates forward when the date hasn't changed
        for (int i = 0; i < reports.size();) {
        	if (reports.get(i).getDate().equals(tempDate)) {
        		i++;
        		if (i == reports.size()) {
        			return minCounters;
        		}
        		else if (reports.get(i).getState().equals(state) && reports.get(i).getCounty().equals(county)) {
            		reportQueue.add(reports.get(i));
            	}
        	}
        	else if (!reports.get(i).getDate().equals(tempDate)) {
        		tempDate = reports.get(i).getDate();
        		//process method
        		minCounters = processQueue(minCounters, reportQueue);


        	}
        }
        return minCounters;
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
		Collections.sort(reports, new timeComparator());
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

	
