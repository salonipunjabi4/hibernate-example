package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.onetomany.Student;
import beans.onetomany.StudentAddress;

public class OneToManyManyToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		
		StudentAddress a1 = new StudentAddress();
		a1.setAddress_details("UK");
		Student customer = new Student();
		customer.setStudent_name("James");
		customer.setStudent_address(a1);
		Student customer1 = new Student();
		customer1.setStudent_name("Max");
		customer1.setStudent_address(a1);
		Set<Student> set = new HashSet<Student>();
		
		set.add(customer);
		set.add(customer1);
		a1.setStudents(set);
		session.save(a1);
		t.commit();
		session.close();
		sessionFactory.close();
		
	}

}
