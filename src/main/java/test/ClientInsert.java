package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class ClientInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		System.out.println("Hello");
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		Employee e1 = new Employee(102, "Allen", "allen@gmail.com", 7548);
		//Integer id = (Integer) s.save(e1);
		s.save(e1);
		//s.saveOrUpdate(e1);
		
		t.commit();
		s.close();
		sf.close();
		
		System.out.println("Data inserted successfully");

	}

}
