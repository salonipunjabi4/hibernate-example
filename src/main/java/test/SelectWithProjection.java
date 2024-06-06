package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class SelectWithProjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		System.out.println("Hello");
		cfg.configure("resources/mysql.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Employee user = null;
		
		//Creating a Criteria instance
		Criteria crit = session.createCriteria(Employee.class);
		ProjectionList prolist = Projections.projectionList();
		prolist.add(Projections.max("salary"));
		prolist.add(Projections.min("salary"));
		prolist.add(Projections.avg("salary"));
		crit.setProjection(prolist);
		List list = crit.list();
		Iterator itr = list.iterator();
		if(!itr.hasNext()) {
			System.out.println("No Data Available!");
		}else {
			while(itr.hasNext()) {
				System.out.println("\n");
				
				Object[] row = (Object[]) itr.next();
				for(int i = 0; i < row.length; i++) {
					if(i == 0) {
						System.out.println("Max Salary is: ");
						System.out.println(row[i]);
						System.out.println("\n");
					}
					if(i == 1) {
						System.out.println("Min Salary is: ");
						System.out.println(row[i]);
						System.out.println("\n");
					}
					if(i == 2) {
						System.out.println("Avg Salary is: ");
						System.out.println(row[i]);
						System.out.println("\n");
					}
				}
			}
		}
		
		
	
		
		
		session.close();
		sessionFactory.close();
	}

}
