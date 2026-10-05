package org.ajdai.CMS.HibernateUtil;

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
		SessionFactory sf = c.buildSessionFactory();
		
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
			c.addAnnotatedClasses(table);
		}
		Session s = sf.openSession();
		return s;
	}
	

}
