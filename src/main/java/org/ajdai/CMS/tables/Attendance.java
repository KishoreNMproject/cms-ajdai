package org.ajdai.CMS.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Attendance {
	@Id
	private String EmployeeID;

	private int TotalDays;
	private int DaysPresent;

	public int getDaysPresent() {
		return DaysPresent;
	}

	public void setDaysPresent(int daysPresent) {
		DaysPresent = daysPresent;
	}

	public static double calculatePercentage(int present, int total) {
		if (total <= 0) {
			return 0.0;
		} else {
			double percentage = (((double) present / total) * 100.0);
			return percentage;
		}
	}

	public int getTotalDays() {
		return TotalDays;
	}

	public void setTotalDays(int totalDays) {
		TotalDays = totalDays;
	}
	

}
