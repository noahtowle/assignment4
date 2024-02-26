package accidentpack;


public class Report {
 public Report(String startTime, String county, String state, int severity, String date) {
	// Sets constructor for all variables of the report to be passed in
	 
	this.startTime = startTime; 
    this.state = state;
    this.county = county;
    this.severity = severity;
    this.setDate(date);
	 
	}
 	
//Getters and Setters 
 
 	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public double getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}
	
	public String getStart_time() {
		return startTime;
	}

	public void setStart_time(String start_time) {
		this.startTime = start_time;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private String startTime;
	private String county;
	private String state;
	private int severity;
	private String date;
	
	


}
