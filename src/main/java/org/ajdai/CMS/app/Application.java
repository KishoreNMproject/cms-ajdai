package org.ajdai.CMS.app;

<<<<<<< HEAD
=======
import java.util.Comparator;
>>>>>>> branch 'main' of https://github.com/KishoreNMproject/cms-ajdai.git
import java.util.List;

import org.ajdai.CMS.HibernateUtil.Util;
import org.ajdai.CMS.tables.Employee;
<<<<<<< HEAD
=======
import org.ajdai.CMS.tables.PerformanceReview;
>>>>>>> branch 'main' of https://github.com/KishoreNMproject/cms-ajdai.git
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Application {
<<<<<<< HEAD
=======

    public static void main(String[] args) {

        Session s = Util.util();
        
        //task 2 -> Find employees whose productivity has decreased for 3 consecutive months
        List<Employee> employees =s.createQuery("from Employee", Employee.class).getResultList();
        for (Employee employee : employees) {

            // getting employee reviews from the performancereview table and stored it in the reviews list
            List<PerformanceReview> reviews =
                    s.createQuery(
                            "from PerformanceReview where employee.id = :id",
                            PerformanceReview.class)
                           .setParameter("id", employee.getId())
                           .getResultList();
            // sort the reviews based on the date 
            reviews.sort(Comparator.comparing(PerformanceReview::getReviewDate));

            if (reviews.size() >= 3) {
                for (int i = 0; i <= reviews.size() - 3; i++) {
                    double first =reviews.get(i).getProductivity();
                    double second =reviews.get(i + 1).getProductivity();
                    double third =reviews.get(i + 2).getProductivity();
                    if (first > second && second > third) {
                        System.out.println(employee.getName() + " productivity decreased for 3 consecutive months."
                        );
                        break;
                    }
                }
            }
        }

        }
		Transaction t = s.beginTransaction();
>>>>>>> branch 'main' of https://github.com/KishoreNMproject/cms-ajdai.git

<<<<<<< HEAD
    public static void main(String[] args) {
=======
		t.commit();
>>>>>>> branch 'main' of https://github.com/KishoreNMproject/cms-ajdai.git

<<<<<<< HEAD
        Session s = Util.util();

        Transaction t = s.beginTransaction();

        String hql =
                "SELECT e.DepartmentID, AVG(e.salary) " +
                "FROM Employee e " +
                "GROUP BY e.DepartmentID " +
                "HAVING AVG(e.salary) > (" +
                "SELECT AVG(e2.salary) FROM Employee e2" +
                ")";

        List<Object[]> result =
                s.createQuery(hql, Object[].class).getResultList();

        for (Object[] row : result) {

            System.out.println(
                    "Department ID: " + row[0] +
                    " | Average Salary: " + row[1]
            );
        }

        t.commit();

        s.close();
    }
}
=======
        s.close();
    }
}
>>>>>>> branch 'main' of https://github.com/KishoreNMproject/cms-ajdai.git
