package com.yash.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student1 = new Student();
		student1.setId(143);
		student1.setName("Rahul");
		student1.setCity("Banglore");

		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Java");
		certificate1.setDuration("2 months");
		student1.setCertificate(certificate1);

		Student student2 = new Student();
		student2.setId(142);
		student2.setName("Rahul");
		student2.setCity("Delhi");

		Certificate certificate2 = new Certificate();
		certificate2.setCourse("Android");
		certificate2.setDuration("2 months");
		student2.setCertificate(certificate2);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

//		save objects
		session.save(student1);
		session.save(student2);

		transaction.commit();
		session.close();
		factory.close();

	}
}
