package test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Criterion;

import beans.Employee;

public class SelectUsingRestriction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		System.out.println("Hello");
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Employee.class);
		Criterion cr = Restrictions.eq("id", 103);
		
		//Restriction - lt, gt, eq (equals, larger than, greater than)
		c.add(cr);
		Employee emp = (Employee) c.uniqueResult(); //select * from employee where id=102
		System.out.println(emp.getId() + "," + emp.getName() + "," + emp.getEmail());
		
		
		session.close();
		sessionFactory.close();
	}

}
