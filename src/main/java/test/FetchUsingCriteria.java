package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class FetchUsingCriteria {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println("Hello");
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		List<Employee> list = c.list();
		
		for(Employee ns : list) {
			System.out.println("Id= " + ns.getId() + ", Name= " + ns.getName() + ", Email= " + ns.getEmail());
		}
		System.out.println("Done");
		session.close();
		sessionFactory.close();
	}

}
