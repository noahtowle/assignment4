package accidentpack;


public class Report {
 public Report(String startTime, String county, String state, int severity) {
	// Sets constructor for all variables of the report to be passed in
	 
	this.startTime = startTime; 
    this.state = state;
    this.county = county;
    this.severity = severity;
	 
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
	
	private String startTime;
	private String county;
	private String state;
	private int severity;
	
	


}
