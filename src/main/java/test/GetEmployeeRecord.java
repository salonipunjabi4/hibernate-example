package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class GetEmployeeRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		System.out.println("Hello");
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		
		Object obj1 = session.get(Employee.class, 103);
		Employee emp = (Employee)obj1;
		System.out.println(emp.getEmail());
		
		//in get transaction is not required
		session.close();
		sessionFactory.close();

	}

}
