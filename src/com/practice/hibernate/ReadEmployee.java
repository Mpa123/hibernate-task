package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Employee;

public class ReadEmployee {

	public static void main(String[] args) {
		
		//Read employees
		
		SessionFactory sf = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class)
					.buildSessionFactory();
		
		try {
			//create new session
			Session sess = sf.getCurrentSession();
			
			//begin transaction
			sess.beginTransaction();
			
			//get employee
			Employee emp = sess.get(Employee.class, 3);
			System.out.println("Emploee : " + emp.toString());
			
			//update employee
			emp.setLastName("Bravar");
			
			
			//commit
			sess.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			sf.close();
		}
	}

}
