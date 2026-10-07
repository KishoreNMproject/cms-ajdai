package org.ajdai.CMS.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Attendance {

    @Id
    private String EmployeeID;

    private int TotalDays;
    private int DaysPresent;
    private double OvertimeHours;

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public int getTotalDays() {
        return TotalDays;
    }

    public void setTotalDays(int totalDays) {
        TotalDays = totalDays;
    }

    public int getDaysPresent() {
        return DaysPresent;
    }

    public void setDaysPresent(int daysPresent) {
        DaysPresent = daysPresent;
    }

    public double getOvertimeHours() {
        return OvertimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        OvertimeHours = overtimeHours;
    }

    public static double calculatePercentage(int present, int total) {
        if (total <= 0) {
            return 0.0;
        }

        return ((double) present / total) * 100.0;
    }
}