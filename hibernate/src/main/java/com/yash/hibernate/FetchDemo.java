package com.yash.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
//	get, load
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

//		get nd load method both used to fetch data 
//		Student student = session.load(Student.class, 103);
		Student student1 = session.get(Student.class, 103);
		Student student2 = session.get(Student.class, 103);

		System.out.println("name of student1 from Student table is " + student1.getName());
		System.out.println("name of student2 from Student table is " + student2.getName());

		Address address = session.load(Address.class, 1);
		System.out.println("name of street from student_address table is " + address.getStreet());

		session.close();
		factory.close();

	}

}
