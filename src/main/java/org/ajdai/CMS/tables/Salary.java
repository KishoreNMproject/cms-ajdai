package org.ajdai.CMS.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Salary {

    @Id
    private int EmployeeID;

    private double Amount;

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}