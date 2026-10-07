package org.ajdai.CMS.HibernateUtil;

//import java.time.LocalDate;

import org.ajdai.CMS.tables.Attendance;
import org.ajdai.CMS.tables.Department;
import org.ajdai.CMS.tables.Emp_Leave;
import org.ajdai.CMS.tables.Employee;

import org.ajdai.CMS.tables.PerformanceReview;
import org.ajdai.CMS.tables.Project;
import org.ajdai.CMS.tables.Salary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Util {

	public static Session util() {
		Configuration cfg = new Configuration();
		Configuration c = cfg.configure();
		

		Class<?>[] tables = { 
				Attendance.class, 
				Department.class, 
				Employee.class, 
				Emp_Leave.class, 
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
//	public static void main(String[] args) {
//
//		Session session = Util.util();
//
//	    Transaction t = session.beginTransaction();
//
//	    Employee emp1 = new Employee();
//	    emp1.setName("Ravi");
//	    emp1.setEmail("ravi@gmail.com");
//	    emp1.setSalary(40000);
//
//	    Employee emp2 = new Employee();
//	    emp2.setName("Arun");
//	    emp2.setEmail("arun@gmail.com");
//	    emp2.setSalary(45000);
//
//	    Employee emp3 = new Employee();
//	    emp3.setName("Kumar");
//	    emp3.setEmail("kumar@gmail.com");
//	    emp3.setSalary(50000);

//	    session.persist(emp1);
//	    session.persist(emp2);
//	    session.persist(emp3);

//	    t.commit();

//	    session.close();
	

//        session.beginTransaction();

//        Employee ravi = session.find(Employee.class, 1);
//        Employee arun = session.find(Employee.class, 2);
//        Employee kumar = session.find(Employee.class, 3);
//
//        PerformanceReview review1 = new PerformanceReview(ravi, LocalDate.of(2026, 1, 1), 90);
//
//        PerformanceReview review2 =new PerformanceReview(ravi, LocalDate.of(2026, 2, 1), 80);
//
//        PerformanceReview review3 =new PerformanceReview(ravi, LocalDate.of(2026, 3, 1), 70);
//
//        PerformanceReview review4 =new PerformanceReview(arun, LocalDate.of(2026, 1, 1), 70);
//
//        PerformanceReview review5 =new PerformanceReview(arun, LocalDate.of(2026, 2, 1), 80);
//
//        PerformanceReview review6 =new PerformanceReview(arun, LocalDate.of(2026, 3, 1), 60);
//
//        PerformanceReview review7 =new PerformanceReview(kumar, LocalDate.of(2026, 1, 1), 90);
//
//        PerformanceReview review8 =new PerformanceReview(kumar, LocalDate.of(2026, 2, 1), 85);
//
//        PerformanceReview review9 =new PerformanceReview(kumar, LocalDate.of(2026, 3, 1), 80);
//
//        session.persist(review1);
//        session.persist(review2);
//        session.persist(review3);
//
//        session.persist(review4);
//        session.persist(review5);
//        session.persist(review6);
//
//        session.persist(review7);
//        session.persist(review8);
//        session.persist(review9);
//
//        t.commit();
//
//        session.close();
//        System.out.println("done");
//    }

}