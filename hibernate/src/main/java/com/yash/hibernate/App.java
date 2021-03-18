package com.yash.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project started... ");

//		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
//		System.out.println(factory.isClosed());

//    creating student 
		Student student = new Student();
		student.setId(103);
		student.setName("yash");
		student.setCity("Pune");
		System.out.println(student);

//		creating obj of Address
		Address address = new Address();
		address.setStreet("street1");
		address.setCity("Pune");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(12.23454);

//		reading image
		FileInputStream fis = new FileInputStream("src/main/java/music_icon.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		address.setImage(data);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student);
		session.save(address);

		tx.commit();
		fis.close();
		session.close();

		System.out.println("done");
	}
}
