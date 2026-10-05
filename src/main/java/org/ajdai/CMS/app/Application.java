package org.ajdai.CMS.app;

import org.ajdai.CMS.HibernateUtil.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.ajdai.CMS.tables.*;

public class Application {
	
	public static void main(String[] args) {
		Session s = Util.util();
		Transaction t = s.beginTransaction();

		
		t.commit();
	}
	

}
