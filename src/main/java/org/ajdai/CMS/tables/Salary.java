package org.ajdai.CMS.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Scanner;
@Entity
public class Salary {
	@Id
	private int EmployeeId;
	
	private int Salary;
	
	private int totalWorkingDays;

	public int getSalary() {
		return Salary;
	}
	
	public int setSalary() {
		return Salary;
	}




}
