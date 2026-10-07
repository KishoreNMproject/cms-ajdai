package org.ajdai.CMS.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    @OneToOne
    private double salary;
    private int DepartmentID;

    private int DepartmentId;
    @OneToMany
    private String ProjectName;

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

<<<<<<< HEAD
    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }
=======

	public int getDepartmentId() {
		return DepartmentId;
	}


	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}
>>>>>>> branch 'main' of https://github.com/KishoreNMproject/cms-ajdai.git
}