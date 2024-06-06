package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		System.out.println("Hello");
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		
		//Employee emp = (Employee) session.get(Employee.class, 103);
		
		//Employee employee = new Employee(103, "Max", "max@gmail.com", 7548);
		//Employee e = new Employee();
		//Integer id = (Integer) s.save(e1);
		//session.update(employee);
		
		Employee employee = new Employee();
		employee.setId(101);
		employee.setEmail("oko@gmail.com");
		
		session.merge(employee);
		//s.saveOrUpdate(e1);
		
		t.commit();
		session.close();
		sessionFactory.close();
		
	}

}
