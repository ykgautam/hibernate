package com.yash.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

//		creating question
		Question question1 = new Question();
		question1.setQuestionId(123);
		question1.setQuestion("what is java?");
//		creating answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(343);
		answer1.setAnswer("java is a programming language");
		answer1.setQuestion(question1);

		question1.setAnswer(answer1);

//		creating question
		Question question2 = new Question();
		question2.setQuestionId(122);
		question2.setQuestion("what is collection framework ?");
//		creating answer
		Answer answer2 = new Answer();
		answer2.setAnswerId(342);
		answer2.setAnswer("API to work with objects in java");
		answer2.setQuestion(question2);

		question2.setAnswer(answer2);

//		session
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

//		save
		session.save(question1);
		session.save(question2);
		session.save(answer1);
		session.save(answer2);

		transaction.commit();

//		fetching fata ...........
		Question q = (Question) session.get(Question.class, 122);
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswer().getAnswer());

		Answer a = session.get(Answer.class, 343);
		System.out.println(a.getQuestion().getQuestion());
		System.out.println(a.getAnswer());

		session.close();
		factory.close();
	}

}
