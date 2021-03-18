package com.yash.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("project started... ");

//		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println(factory);
		System.out.println(factory.isClosed());

//		factory.getCurrentSession();

	}
}
