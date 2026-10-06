package org.ajdai.CMS.app;

import org.ajdai.CMS.HibernateUtil.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.ajdai.CMS.tables.*;

public class Application {
	
	public static void main(String[] args) {
		Session s = Util.util();
		
		//fetch who are all did more than 3 projects and have below average performance
		
		
//		Employee emp = new Employee();
//		PerformanceReview perf = new PerformanceReview();
//		Project pro = new Project();
		Transaction t =s.beginTransaction();
		
		
		t.commit();
	}
	

}
