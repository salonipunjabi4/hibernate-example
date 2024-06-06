package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import beans.Employee;

public class SelectMultipleRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		System.out.println("Hello");
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		/*
		 * Perfoming select operation
		 * String hql = "from Employee"; Query q = session.createQuery(hql);
		 * List<Employee> list = (List<Employee>) q.list();
		 * 
		 * for(Employee ns1:list) { System.out.println("Id= " + ns1.getId());
		 * System.out.println("Name= " + ns1.getName()); System.out.println("Email= " +
		 * ns1.getEmail()); System.out.println("Salary= " + ns1.getSalary()); }
		 */	
		
		/*
		 * //Performing delete operation with where clause Transaction t =
		 * session.beginTransaction(); String hql =
		 * "delete from Employee where id=:eid"; Query q = session.createQuery(hql);
		 * q.setParameter("eid", 102); int res = q.executeUpdate(); t.commit(); if(res >
		 * 0) { System.out.println("Data deleted successfully"); }else {
		 * System.out.println("Data deletion failure"); }
		 */
		
		
		/*
		 * Performing select operation with where clause
		 * String hql = "from Employee where id=101"; 
		 * Query q = session.createQuery(hql); 
		 * Employee ns = (Employee) q.uniqueResult();
		 * System.out.println("Id= " + ns.getId()); 
		 * System.out.println("Name= " + ns.getName()); 
		 * System.out.println("Email= " + ns.getEmail());
		 * System.out.println("Salary= " + ns.getSalary());
		 * System.out.println("Data deleted sucessfully");
		 */	
		
		//Performing update operation
		Transaction t = session.beginTransaction();
		String  hql = "update Employee set name = 'Allen', email = 'allen@gmail.com' where id = 101";
		Query q = session.createQuery(hql);
		int i = q.executeUpdate();
		t.commit();
		System.out.println("Data updated successfully");
		
		
		session.close();
		sessionFactory.close();
	}

}
