package accidentpack;

import java.util.Comparator;

class timeComparator implements Comparator<Report> {
	@Override
	public int compare(Report report1, Report report2) {
		// Compare reports based on their streets
		return report1.getStart_time().compareTo(report2.getStart_time());
	}

}