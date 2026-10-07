package org.ajdai.CMS.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Emp_Leave {
	
	@Id
	private int EmployeeID;
	
	private int totalLeaves;
	
	private String EmployeeName;
	
	private int leaveTaken;

//	private int RemainingLeaves;
	
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

//	public void setRemainingLeaves(int remainingLeaves) {
//		this.RemainingLeaves = remainingLeaves;
//	}

	public void takeLeave(int days) {
        if (days <= getRemainingLeaves()) {
            leaveTaken += days;
            System.out.println(days + " day(s) of leave approved for " + EmployeeName + ".");
        } else {
            System.out.println("Error: Insufficient leave balance for " + EmployeeName + ".");
        }
    }

    public int getRemainingLeaves() {
        return totalLeaves - leaveTaken;
    }

}
