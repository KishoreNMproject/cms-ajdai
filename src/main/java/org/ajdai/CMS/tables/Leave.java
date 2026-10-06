package org.ajdai.CMS.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Leave {
	
	@Id
	private int EmployeeID;
	@Column(nullable = false)
	private int totalLeaves;
	@Column(nullable = false)
	private String EmployeeName;
	
	private int leaveTaken;
	private int remainingLeaves;

	private int Leave() {
		remainingLeaves = totalLeaves - leaveTaken;
		return remainingLeaves;
	}
	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public int getLeaveTaken() {
		return leaveTaken;
	}

	public void setLeaveTaken(int leaveTaken) {
		this.leaveTaken = leaveTaken;
	}

	public void setRemainingLeaves(int remainingLeaves) {
		this.remainingLeaves = remainingLeaves;
	}

	public void takeLeave(int days) {
        if (days <= getRemainingLeaves()) {
            leaveTaken += days;
            System.out.println(days + " day(s) of leave approved for " + EmployeeName + ".");
        } else {
            System.out.println("Error: Insufficient leave balance for " + EmployeeName + ".");
        }
    }

    public int getRemainingLeaves() {
        return Leave();
    }

}
