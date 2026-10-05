package org.ajdai.CMS.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Department")
public class Department {
	
	
		@Id
		private int DepartmentID;

		public int getDepartmentID() {
			return DepartmentID;
		}

		public void setDepartmentID(int departmentID) {
			DepartmentID = departmentID;
		}
		
		
}

