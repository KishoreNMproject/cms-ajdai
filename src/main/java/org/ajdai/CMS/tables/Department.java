package org.ajdai.CMS.tables;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "Department")
public class Department {
	
	
		@Id
		private int DepartmentID;
		
		@OneToMany(mappedBy = "department")
        private List<Employee> employees;
		
		
		public int getDepartmentID() {
			return DepartmentID;
		}

		public void setDepartmentID(int departmentID) {
			DepartmentID = departmentID;
		}

		public List<Employee> getEmployees() {
			return employees;
		}

		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}
		
		
}

