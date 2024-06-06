package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Laptop;
import beans.Student;

public class OneToOneMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		Student s1 = new Student();
		s1.setRollNo(2);
		s1.setStudName("Allen");
		s1.setMarks(90);
		
		Laptop l1 = new Laptop();
		l1.setLid(102);
		l1.setLname("Macbook");
		l1.setStudent(s1);
		
		s1.setLaptop(l1);
		session.persist(s1);
		t.commit();
		
		session.close();
		sessionFactory.close();

	}

}
