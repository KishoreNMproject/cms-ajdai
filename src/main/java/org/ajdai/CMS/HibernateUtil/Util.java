package org.ajdai.CMS.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ajdai.CMS.tables.Attendance;
import org.ajdai.CMS.tables.Department;
import org.ajdai.CMS.tables.Employee;
import org.ajdai.CMS.tables.Leave;
import org.ajdai.CMS.tables.PerformanceReview;
import org.ajdai.CMS.tables.Project;
import org.ajdai.CMS.tables.Salary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {

	public static Session util() {
		Configuration cfg = new Configuration();
		Configuration c = cfg.configure();
		

		Class<?>[] tables = { 
				Attendance.class, 
				Department.class, 
				Employee.class, 
				Leave.class, 
				PerformanceReview.class,
				Project.class, 
				Salary.class 
				};

		for (Class<?> table : tables) {
			c.addAnnotatedClass(table);
		}
		SessionFactory sf = c.buildSessionFactory();
		 
		return sf.openSession();
	}

	public static void main(String[] args) {
		Session session = Util.util();

		session.beginTransaction();
		
		Department it = new Department();
		it.setDepartmentID(1);

		Department hr = new Department();
		hr.setDepartmentID(2);
		
		Employee emp1 = new Employee();
		emp1.setName("Ravi");
		emp1.setEmail("ravi@gmail.com");
		emp1.setSalary(40000);
	    emp1.setDepartment(it);
	    
		Employee emp2 = new Employee();
		emp2.setName("Arun");
		emp2.setEmail("arun@gmail.com");
		emp2.setSalary(45000);
        emp2.setDepartment(it);
        
		Employee emp3 = new Employee();
		emp3.setName("Kumar");
		emp3.setEmail("kumar@gmail.com");
		emp3.setSalary(50000);
		emp3.setDepartment(hr);
        
		session.persist(it);
		session.persist(hr);
		session.persist(emp1);
		session.persist(emp2);
		session.persist(emp3);
		
		PerformanceReview review1 = new PerformanceReview(emp1, LocalDate.of(2026, 1, 1), 90);

		PerformanceReview review2 = new PerformanceReview(emp1, LocalDate.of(2026, 2, 1), 80);

		PerformanceReview review3 = new PerformanceReview(emp1, LocalDate.of(2026, 3, 1), 70);

		PerformanceReview review4 = new PerformanceReview(emp2, LocalDate.of(2026, 1, 1), 70);

		PerformanceReview review5 = new PerformanceReview(emp2, LocalDate.of(2026, 2, 1), 80);

		PerformanceReview review6 = new PerformanceReview(emp2, LocalDate.of(2026, 3, 1), 60);

		PerformanceReview review7 = new PerformanceReview(emp3, LocalDate.of(2026, 1, 1), 90);

		PerformanceReview review8 = new PerformanceReview(emp3, LocalDate.of(2026, 2, 1), 85);

		PerformanceReview review9 = new PerformanceReview(emp3, LocalDate.of(2026, 3, 1), 80);

		session.persist(review1);
		session.persist(review2);
		session.persist(review3);

		session.persist(review4);
		session.persist(review5);
		session.persist(review6);

		session.persist(review7);
		session.persist(review8);
		session.persist(review9);

		session.getTransaction().commit();
		List<PerformanceReview> reviews = session.createQuery("from PerformanceReview", PerformanceReview.class)
				.getResultList();
		for (PerformanceReview review : reviews) {
		    System.out.println(
		        review.getEmployee().getName()
		        + " : "
		        + review.getProductivity()
		    );
		}
		Map<Employee, Double> totalPerformance = new HashMap<>();
		Map<Employee, Integer> reviewCount = new HashMap<>();
		
		for (PerformanceReview review : reviews) {

			Employee employee = review.getEmployee();

			totalPerformance.put(employee, totalPerformance.getOrDefault(employee, 0.0) + review.getProductivity());

			reviewCount.put(employee, reviewCount.getOrDefault(employee, 0) + 1);
		}
		for (Employee employee : totalPerformance.keySet()) {

			double total = totalPerformance.get(employee);
			int count = reviewCount.get(employee);

			double average = total / count;

			System.out.println(employee.getName() + " → Average Performance: " + average);
		}
		Map<Department, List<Employee>> departmentEmployees = new HashMap<>();
		for (Employee employee : totalPerformance.keySet()) {

		    Department department = employee.getDepartment();

		    departmentEmployees
		        .computeIfAbsent(department, d -> new ArrayList<>())
		        .add(employee);
		}
		for (Department department : departmentEmployees.keySet()) {

		    System.out.println("Department: " + department.getDepartmentID());

		    List<Employee> employees = departmentEmployees.get(department);

		    employees.sort(
		        Comparator.comparingDouble(
		            employee -> totalPerformance.get(employee) / reviewCount.get(employee)
		        ).reversed()
		    );

		    for (Employee employee : employees) {

		        System.out.println(
		            employee.getName()
		            + " → Average Performance: "
		            + (totalPerformance.get(employee) / reviewCount.get(employee))
		        );
		    }
		}
		
		session.close();
	}	

}
