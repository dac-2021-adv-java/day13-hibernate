package in.edac;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.edac.entity.Student;

public class HibernateCriteriaDemo {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		demo3();
	}
	
	
	public static void demo3() {
		Session session =  sessionFactory.openSession();

		Criteria cr =  session.createCriteria(Student.class);
		cr.add(Restrictions.gt("id", 2));
		
		List<Student> list =  cr.list();
		
		list.stream().map(Student::getName).forEach(System.out::println);
		
		session.close();
	}
	
	
	public static void demo2() {
		Session session =  sessionFactory.openSession();

		Criteria cr =  session.createCriteria(Student.class);
		cr.add(Restrictions.eq("id", 1));
		
		List<Student> list =  cr.list();
		
		list.stream().map(Student::getName).forEach(System.out::println);
		
		session.close();
	}
	
	
	
	public static void demo1() {
		Session session =  sessionFactory.openSession();

		Criteria cr =  session.createCriteria(Student.class);
		List<Student> list =  cr.list();
		
		list.stream().map(Student::getName).forEach(System.out::println);
		
		session.close();
	}

}
