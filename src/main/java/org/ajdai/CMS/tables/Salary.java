package org.ajdai.CMS.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Scanner;
@Entity
public class Salary {
	@Id
	private int EmployeeId;
	@Column(nullable = false)
	private int Salary;
	@Column(nullable = false)
	private int totalWorkingDays;

	public int getSalary() {
		return Salary;
	}
	
	public int setSalary() {
		return Salary;
	}

	public int getTotalWorkingDays() {
		return totalWorkingDays;
	}

	public void setTotalWorkingDays(int totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}




}
