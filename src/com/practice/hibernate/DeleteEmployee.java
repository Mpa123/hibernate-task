package com.practice.hibernate;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Employee;

public class DeleteEmployee {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Employee.class)
						.buildSessionFactory();
		
		try {
			
			Session sess = sf.getCurrentSession();
			sess.beginTransaction();
			Query q = sess.createQuery("FROM Employee WHERE lastName = 'Pigo'");
			Employee emp = (Employee)q.getSingleResult();
			sess.delete(emp);
			sess.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			sf.close();
		}
	}

}
