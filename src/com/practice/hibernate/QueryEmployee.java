package com.practice.hibernate;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Employee;

public class QueryEmployee {
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sf = new Configuration()
						.configure()
						.addAnnotatedClass(Employee.class)
						.buildSessionFactory();
		
		try {
			
			//create session
			Session sess = sf.getCurrentSession();
			
			//begin transaction
			sess.beginTransaction();
			
			//query employee
			Query q = sess.createQuery("FROM Employee WHERE lastName LIKE '%avar'");
			Employee emp = (Employee)q.getSingleResult();
			emp.setLastName("Cavar");
			System.out.println(emp.toString());
			//commit transaction
			sess.getTransaction().commit();
			

		}
		finally {
			//close session factory
			sf.close();
		}
		
	}

}
