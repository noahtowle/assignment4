package accidentpack;


public class Report implements Comparable<Report> {
 public Report(String startTime, String county, String state, double visibility) {
	// Sets constructor for all variables of the report to be passed in
	 
	this.startTime = startTime; 
    this.state = state;
    this.county = county;
    this.visibility = visibility;
	 
	}
 	
//Getters and Setters 
 
 	public String getCounty() {
		return county;
	}

	public void setCounty(String street) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
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
	private double visibility;
	
	
	@Override
	//Compares this report to the other report and returns a value based on difference of visibility in the two reports.
	public int compareTo(Report other) {
		return Double.compare(visibility, other.getVisibility());
	}


}
