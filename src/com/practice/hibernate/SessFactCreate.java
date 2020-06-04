package com.practice.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Employee;

public class SessFactCreate {
	
	public static SessionFactory createSessFact() {
		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		return sf;
		
	}

}
