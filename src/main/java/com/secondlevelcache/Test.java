package com.secondlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration con = new Configuration();
		con.configure();
		SessionFactory factory = con.buildSessionFactory();
		Student s = new Student();
//		s.setRoll(10);
		s.setName("Ram");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(s);
		System.out.println(s);
		tx.commit();
		session.close();
		Session session1=factory.openSession();
		Transaction tx1=session1.beginTransaction();
		Student s1 = session1.get(Student.class, 1);
		System.out.println(s1);
		tx1.commit();
		session1.close();
		
		factory.close();

	}
}
