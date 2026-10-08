package org.ajdai.CMS.app.inserter;

import java.time.LocalDate;
import java.util.List;

import org.ajdai.CMS.HibernateUtil.Util;
import org.ajdai.CMS.tables.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class Inserter {

    public static void DataInsert() {

        // Wipe existing database tables
        wipeDatabase();

        Session s = Util.util();
        Transaction t = s.beginTransaction();

        // =========================
        // Departments
        // =========================

        Department d1 = new Department();
        d1.setDepartmentID(1);

        Department d2 = new Department();
        d2.setDepartmentID(2);

        s.persist(d1);
        s.persist(d2);

        // =========================
        // Employees
        // =========================

        Employee e1 = new Employee();
        e1.setName("Arun");
        e1.setEmail("arun@gmail.com");
        e1.setSalary(60000);
        e1.setDepartmentID(1);

        Employee e2 = new Employee();
        e2.setName("Ravi");
        e2.setEmail("ravi@gmail.com");
        e2.setSalary(65000);
        e2.setDepartmentID(1);

        Employee e3 = new Employee();
        e3.setName("Kumar");
        e3.setEmail("kumar@gmail.com");
        e3.setSalary(55000);
        e3.setDepartmentID(1);

        Employee e4 = new Employee();
        e4.setName("Vijay");
        e4.setEmail("vijay@gmail.com");
        e4.setSalary(70000);
        e4.setDepartmentID(1);

        Employee e5 = new Employee();
        e5.setName("Ajay");
        e5.setEmail("ajay@gmail.com");
        e5.setSalary(55000);
        e5.setDepartmentID(1);

        Employee e6 = new Employee();
        e6.setName("Suresh");
        e6.setEmail("suresh@gmail.com");
        e6.setSalary(35000);
        e6.setDepartmentID(2);

        Employee e7 = new Employee();
        e7.setName("Manoj");
        e7.setEmail("manoj@gmail.com");
        e7.setSalary(40000);
        e7.setDepartmentID(2);

        Employee e8 = new Employee();
        e8.setName("Dinesh");
        e8.setEmail("dinesh@gmail.com");
        e8.setSalary(45000);
        e8.setDepartmentID(2);

        s.persist(e1);
        s.persist(e2);
        s.persist(e3);
        s.persist(e4);
        s.persist(e5);
        s.persist(e6);
        s.persist(e7);
        s.persist(e8);

        // =========================
        // Performance Reviews
        // =========================

        // Arun: 70, 70, 70
        PerformanceReview p1 = new PerformanceReview();
        p1.setEmployee(e1);
        p1.setReviewDate(LocalDate.of(2026, 1, 1));
        p1.setProductivity(70);

        PerformanceReview p2 = new PerformanceReview();
        p2.setEmployee(e1);
        p2.setReviewDate(LocalDate.of(2026, 2, 1));
        p2.setProductivity(70);

        PerformanceReview p3 = new PerformanceReview();
        p3.setEmployee(e1);
        p3.setReviewDate(LocalDate.of(2026, 3, 1));
        p3.setProductivity(70);

        // Ravi: 90, 80, 70
        PerformanceReview p4 = new PerformanceReview();
        p4.setEmployee(e2);
        p4.setReviewDate(LocalDate.of(2026, 1, 1));
        p4.setProductivity(90);

        PerformanceReview p5 = new PerformanceReview();
        p5.setEmployee(e2);
        p5.setReviewDate(LocalDate.of(2026, 2, 1));
        p5.setProductivity(80);

        PerformanceReview p6 = new PerformanceReview();
        p6.setEmployee(e2);
        p6.setReviewDate(LocalDate.of(2026, 3, 1));
        p6.setProductivity(70);

        // Kumar: 95, 85, 75
        PerformanceReview p7 = new PerformanceReview();
        p7.setEmployee(e3);
        p7.setReviewDate(LocalDate.of(2026, 1, 1));
        p7.setProductivity(95);

        PerformanceReview p8 = new PerformanceReview();
        p8.setEmployee(e3);
        p8.setReviewDate(LocalDate.of(2026, 2, 1));
        p8.setProductivity(85);

        PerformanceReview p9 = new PerformanceReview();
        p9.setEmployee(e3);
        p9.setReviewDate(LocalDate.of(2026, 3, 1));
        p9.setProductivity(75);

        // Vijay: 88, 88, 88
        PerformanceReview p10 = new PerformanceReview();
        p10.setEmployee(e4);
        p10.setReviewDate(LocalDate.of(2026, 1, 1));
        p10.setProductivity(88);

        PerformanceReview p11 = new PerformanceReview();
        p11.setEmployee(e4);
        p11.setReviewDate(LocalDate.of(2026, 2, 1));
        p11.setProductivity(88);

        PerformanceReview p12 = new PerformanceReview();
        p12.setEmployee(e4);
        p12.setReviewDate(LocalDate.of(2026, 3, 1));
        p12.setProductivity(88);

        // Ajay: 82, 82, 82
        PerformanceReview p13 = new PerformanceReview();
        p13.setEmployee(e5);
        p13.setReviewDate(LocalDate.of(2026, 1, 1));
        p13.setProductivity(82);

        PerformanceReview p14 = new PerformanceReview();
        p14.setEmployee(e5);
        p14.setReviewDate(LocalDate.of(2026, 2, 1));
        p14.setProductivity(82);

        PerformanceReview p15 = new PerformanceReview();
        p15.setEmployee(e5);
        p15.setReviewDate(LocalDate.of(2026, 3, 1));
        p15.setProductivity(82);

        // Suresh: 65, 65, 65
        PerformanceReview p16 = new PerformanceReview();
        p16.setEmployee(e6);
        p16.setReviewDate(LocalDate.of(2026, 1, 1));
        p16.setProductivity(65);

        PerformanceReview p17 = new PerformanceReview();
        p17.setEmployee(e6);
        p17.setReviewDate(LocalDate.of(2026, 2, 1));
        p17.setProductivity(65);

        PerformanceReview p18 = new PerformanceReview();
        p18.setEmployee(e6);
        p18.setReviewDate(LocalDate.of(2026, 3, 1));
        p18.setProductivity(65);

        // Manoj: 75, 75, 75
        PerformanceReview p19 = new PerformanceReview();
        p19.setEmployee(e7);
        p19.setReviewDate(LocalDate.of(2026, 1, 1));
        p19.setProductivity(75);

        PerformanceReview p20 = new PerformanceReview();
        p20.setEmployee(e7);
        p20.setReviewDate(LocalDate.of(2026, 2, 1));
        p20.setProductivity(75);

        PerformanceReview p21 = new PerformanceReview();
        p21.setEmployee(e7);
        p21.setReviewDate(LocalDate.of(2026, 3, 1));
        p21.setProductivity(75);

        // Dinesh: 60, 60, 60
        PerformanceReview p22 = new PerformanceReview();
        p22.setEmployee(e8);
        p22.setReviewDate(LocalDate.of(2026, 1, 1));
        p22.setProductivity(60);

        PerformanceReview p23 = new PerformanceReview();
        p23.setEmployee(e8);
        p23.setReviewDate(LocalDate.of(2026, 2, 1));
        p23.setProductivity(60);

        PerformanceReview p24 = new PerformanceReview();
        p24.setEmployee(e8);
        p24.setReviewDate(LocalDate.of(2026, 3, 1));
        p24.setProductivity(60);

        s.persist(p1);
        s.persist(p2);
        s.persist(p3);
        s.persist(p4);
        s.persist(p5);
        s.persist(p6);
        s.persist(p7);
        s.persist(p8);
        s.persist(p9);
        s.persist(p10);
        s.persist(p11);
        s.persist(p12);
        s.persist(p13);
        s.persist(p14);
        s.persist(p15);
        s.persist(p16);
        s.persist(p17);
        s.persist(p18);
        s.persist(p19);
        s.persist(p20);
        s.persist(p21);
        s.persist(p22);
        s.persist(p23);
        s.persist(p24);

        // =========================
        // Projects
        // =========================

        // Suresh - 5 projects
        Project project1 = new Project();
        project1.setProjectName("Project A");
        project1.setEmployeeId(e6.getId());

        Project project2 = new Project();
        project2.setProjectName("Project B");
        project2.setEmployeeId(e6.getId());

        Project project3 = new Project();
        project3.setProjectName("Project C");
        project3.setEmployeeId(e6.getId());

        Project project4 = new Project();
        project4.setProjectName("Project D");
        project4.setEmployeeId(e6.getId());

        Project project5 = new Project();
        project5.setProjectName("Project E");
        project5.setEmployeeId(e6.getId());

        // Manoj - 3 projects
        Project project6 = new Project();
        project6.setProjectName("Project F");
        project6.setEmployeeId(e7.getId());

        Project project7 = new Project();
        project7.setProjectName("Project G");
        project7.setEmployeeId(e7.getId());

        Project project8 = new Project();
        project8.setProjectName("Project H");
        project8.setEmployeeId(e7.getId());

        s.persist(project1);
        s.persist(project2);
        s.persist(project3);
        s.persist(project4);
        s.persist(project5);
        s.persist(project6);
        s.persist(project7);
        s.persist(project8);

        // =========================
        // Attendance
        // =========================

        Attendance a1 = new Attendance();
        a1.setEmployeeID(String.valueOf(e1.getId()));
        a1.setTotalDays(22);
        a1.setDaysPresent(21);
        a1.setOvertimeHours(2);

        Attendance a2 = new Attendance();
        a2.setEmployeeID(String.valueOf(e2.getId()));
        a2.setTotalDays(22);
        a2.setDaysPresent(21);
        a2.setOvertimeHours(3);

        Attendance a3 = new Attendance();
        a3.setEmployeeID(String.valueOf(e3.getId()));
        a3.setTotalDays(22);
        a3.setDaysPresent(20);
        a3.setOvertimeHours(4);

        Attendance a4 = new Attendance();
        a4.setEmployeeID(String.valueOf(e4.getId()));
        a4.setTotalDays(22);
        a4.setDaysPresent(22);
        a4.setOvertimeHours(12);

        Attendance a5 = new Attendance();
        a5.setEmployeeID(String.valueOf(e5.getId()));
        a5.setTotalDays(22);
        a5.setDaysPresent(21);
        a5.setOvertimeHours(2);

        Attendance a6 = new Attendance();
        a6.setEmployeeID(String.valueOf(e6.getId()));
        a6.setTotalDays(22);
        a6.setDaysPresent(20);
        a6.setOvertimeHours(3);

        Attendance a7 = new Attendance();
        a7.setEmployeeID(String.valueOf(e7.getId()));
        a7.setTotalDays(22);
        a7.setDaysPresent(21);
        a7.setOvertimeHours(5);

        Attendance a8 = new Attendance();
        a8.setEmployeeID(String.valueOf(e8.getId()));
        a8.setTotalDays(22);
        a8.setDaysPresent(19);
        a8.setOvertimeHours(2);

        s.persist(a1);
        s.persist(a2);
        s.persist(a3);
        s.persist(a4);
        s.persist(a5);
        s.persist(a6);
        s.persist(a7);
        s.persist(a8);

        // =========================
        // Employee Leave
        // =========================

        Emp_Leave l1 = new Emp_Leave();
        l1.setEmployeeID(e1.getId());
        l1.setEmployeeName(e1.getName());
        l1.setTotalLeaves(20);
        l1.setLeaveTaken(5);
        l1.setRemainingLeaves(15);

        Emp_Leave l2 = new Emp_Leave();
        l2.setEmployeeID(e2.getId());
        l2.setEmployeeName(e2.getName());
        l2.setTotalLeaves(20);
        l2.setLeaveTaken(3);
        l2.setRemainingLeaves(17);

        Emp_Leave l3 = new Emp_Leave();
        l3.setEmployeeID(e3.getId());
        l3.setEmployeeName(e3.getName());
        l3.setTotalLeaves(20);
        l3.setLeaveTaken(8);
        l3.setRemainingLeaves(12);

        Emp_Leave l4 = new Emp_Leave();
        l4.setEmployeeID(e4.getId());
        l4.setEmployeeName(e4.getName());
        l4.setTotalLeaves(20);
        l4.setLeaveTaken(2);
        l4.setRemainingLeaves(18);

        Emp_Leave l5 = new Emp_Leave();
        l5.setEmployeeID(e5.getId());
        l5.setEmployeeName(e5.getName());
        l5.setTotalLeaves(20);
        l5.setLeaveTaken(6);
        l5.setRemainingLeaves(14);

        Emp_Leave l6 = new Emp_Leave();
        l6.setEmployeeID(e6.getId());
        l6.setEmployeeName(e6.getName());
        l6.setTotalLeaves(20);
        l6.setLeaveTaken(10);
        l6.setRemainingLeaves(10);

        Emp_Leave l7 = new Emp_Leave();
        l7.setEmployeeID(e7.getId());
        l7.setEmployeeName(e7.getName());
        l7.setTotalLeaves(20);
        l7.setLeaveTaken(4);
        l7.setRemainingLeaves(16);

        Emp_Leave l8 = new Emp_Leave();
        l8.setEmployeeID(e8.getId());
        l8.setEmployeeName(e8.getName());
        l8.setTotalLeaves(20);
        l8.setLeaveTaken(7);
        l8.setRemainingLeaves(13);

        s.persist(l1);
        s.persist(l2);
        s.persist(l3);
        s.persist(l4);
        s.persist(l5);
        s.persist(l6);
        s.persist(l7);
        s.persist(l8);

        // =========================
        // Commit
        // =========================

        t.commit();
        s.close();
    }

    // =========================
    // Database Wiper
    // =========================

	private static void wipeDatabase() {

        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        try (
            SessionFactory sessionFactory =
                    new MetadataSources(registry)
                            .buildMetadata()
                            .buildSessionFactory();

            Session session = sessionFactory.openSession()
        ) {

            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

            String connectionUrl =
                    cfg.getProperty("hibernate.connection.url");

            String databaseName =
                    connectionUrl.substring(
                            connectionUrl.lastIndexOf("/") + 1
                    );

            if (databaseName.contains("?")) {
                databaseName =
                        databaseName.substring(
                                0,
                                databaseName.indexOf("?")
                        );
            }

            System.out.println("Targeting Database: " + databaseName);

            Transaction transaction = session.beginTransaction();

            try {

                String fetchTablesSql =
                        "SELECT table_name " +
                        "FROM information_schema.tables " +
                        "WHERE table_schema = :dbName";

                NativeQuery<String> fetchQuery =
                        session.createNativeQuery(
                                fetchTablesSql,
                                String.class
                        );

                fetchQuery.setParameter("dbName", databaseName);

                List<String> tableNames =
                        fetchQuery.getResultList();

                if (!tableNames.isEmpty()) {

                	session.createNativeMutationQuery(
                		    "SET FOREIGN_KEY_CHECKS = 0"
                		).executeUpdate();

                    for (String tableName : tableNames) {

                        String dropSql =
                                "DROP TABLE IF EXISTS `" +
                                tableName +
                                "`";

                        session.createNativeMutationQuery(dropSql)
                        .executeUpdate();

                        
                    }

                    session.createNativeMutationQuery(
                    	    "SET FOREIGN_KEY_CHECKS = 1"
                    		).executeUpdate();

                } 
                

                transaction.commit();

                System.out.println(
                        "Database tables reset successfully."
                );

            } catch (Exception e) {

                if (transaction != null) {
                    transaction.rollback();
                }

                e.printStackTrace();
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}