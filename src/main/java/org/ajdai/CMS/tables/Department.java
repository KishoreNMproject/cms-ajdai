package org.ajdai.CMS.tables;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
<<<<<<< HEAD

    @Id
    private int DepartmentID;
=======
	
	
		@Id
		private int DepartmentID;
		
		@OneToMany(mappedBy = "department")
        private List<Employee> employees;
		
		
		public int getDepartmentID() {
			return DepartmentID;
		}
>>>>>>> branch 'main' of https://github.com/KishoreNMproject/cms-ajdai.git

<<<<<<< HEAD
    public int getDepartmentID() {
        return DepartmentID;
    }
=======
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
>>>>>>> branch 'main' of https://github.com/KishoreNMproject/cms-ajdai.git

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }
}