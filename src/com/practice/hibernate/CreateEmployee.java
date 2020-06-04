package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.entity.Employee;

public class CreateEmployee {
	
	public static void main(String[] args) {
		
		//CREATE new employee
		
		SessionFactory sf = SessFactCreate.createSessFact();
		
		try {
		//create session
		Session sess = sf.getCurrentSession();
		
		//begin transaction
		sess.beginTransaction();
		
		//create new Employee object
		Employee newEmp = new Employee("Jurica", "Sestok", "ETK");
		System.out.println("Saving employee to DB");
		sess.save(newEmp);
		
		sess.getTransaction().commit();
		
		System.out.println("Done!");
		
		}
		finally {
			sf.close();
		}
		
		
		
		
		
	}
	
	
}