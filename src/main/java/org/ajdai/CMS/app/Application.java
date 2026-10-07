package org.ajdai.CMS.app;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.ajdai.CMS.HibernateUtil.Util;
import org.ajdai.CMS.tables.Employee;
import org.ajdai.CMS.tables.PerformanceReview;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Application {

    public static void main(String[] args) {

        Session s = Util.util();

        Transaction t = s.beginTransaction();
        System.out.println("=====================================================================================");

        // Task 1 - Find the top 5 employees in every department
        // based on performance
        System.out.println("Task1: Find the top 5 employees in every department based on performance");
        
        System.out.println("=====================================================================================");

        List<Employee> employees =
                s.createQuery("from Employee", Employee.class)
                 .getResultList();

        Map<Integer, List<Employee>> departmentEmployees =
                employees.stream()
                         .collect(Collectors.groupingBy(
                                 Employee::getDepartmentID
                         ));

        for (Map.Entry<Integer, List<Employee>> entry :
                departmentEmployees.entrySet()) {

            int departmentID = entry.getKey();

            List<Employee> departmentList = entry.getValue();

            departmentList.sort((e1, e2) -> {

                Double performance1 =
                        s.createQuery(
                                "select avg(p.productivity) " +
                                "from PerformanceReview p " +
                                "where p.employee.id = :id",
                                Double.class)
                         .setParameter("id", e1.getId())
                         .getSingleResult();

                Double performance2 =
                        s.createQuery(
                                "select avg(p.productivity) " +
                                "from PerformanceReview p " +
                                "where p.employee.id = :id",
                                Double.class)
                         .setParameter("id", e2.getId())
                         .getSingleResult();

                if (performance1 == null) {
                    performance1 = 0.0;
                }

                if (performance2 == null) {
                    performance2 = 0.0;
                }

                return Double.compare(performance2, performance1);
            });

            System.out.println(
                    "\nDepartment ID: " + departmentID
            );

            int limit = Math.min(5, departmentList.size());

            for (int i = 0; i < limit; i++) {

                Employee employee = departmentList.get(i);

                Double performance =
                        s.createQuery(
                                "select avg(p.productivity) " +
                                "from PerformanceReview p " +
                                "where p.employee.id = :id",
                                Double.class)
                         .setParameter("id", employee.getId())
                         .getSingleResult();

                if (performance == null) {
                    performance = 0.0;
                }

                System.out.println(
                        (i + 1) + ". "
                        + employee.getName()
                        + " | Performance: "
                        + performance
                );
            }
        }
        System.out.println("=====================================================================================");
        // Task 2 - Find employees whose productivity has decreased
        // for 3 consecutive months
        System.out.println("Task2: Find Employees whose productivity has decreased for 3 consecutive months");
        
        System.out.println("=====================================================================================");

        for (Employee employee : employees) {

            List<PerformanceReview> reviews =
                    s.createQuery(
                            "from PerformanceReview where employee.id = :id",
                            PerformanceReview.class)
                     .setParameter("id", employee.getId())
                     .getResultList();

            reviews.sort(
                    Comparator.comparing(PerformanceReview::getReviewDate)
            );

            if (reviews.size() >= 3) {

                for (int i = 0; i <= reviews.size() - 3; i++) {

                    double first =
                            reviews.get(i).getProductivity();

                    double second =
                            reviews.get(i + 1).getProductivity();

                    double third =
                            reviews.get(i + 2).getProductivity();

                    if (first > second && second > third) {

                        System.out.println(
                                employee.getName()
                                + " productivity decreased for 3 consecutive months."
                        );

                        break;
                    }
                }
            }
        }
        System.out.println("=====================================================================================");

        // Task 3 - Find departments whose average salary
        // is greater than the company average salary

        System.out.println("Task 3: Find departments whose average salary is greater than"
        		+ "the company average salary");
        System.out.println("=====================================================================================");

        String hql =
                "SELECT e.DepartmentID, AVG(e.salary) " +
                "FROM Employee e " +
                "GROUP BY e.DepartmentID " +
                "HAVING AVG(e.salary) > (" +
                "SELECT AVG(e2.salary) FROM Employee e2" +
                ")";
        
        List<Object[]> result =
                s.createQuery(hql, Object[].class)
                 .getResultList();

        for (Object[] row : result) {

            System.out.println(
                    "Department ID: " + row[0]
                    + " | Average Salary: " + row[1]
            );
        }
        
        System.out.println("=====================================================================================");


        t.commit();

        s.close();
    }
}