package in.edac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Address;
import in.edac.entity.Student;


public class OneToOneJoinDemo {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		readRecord();
	}
	
	public static void readRecord() {
		Session session =  sessionFactory.openSession();
		
		Student st = session.find(Student.class, 9);
		System.out.println(st);
		
		session.close();
	}
	
	public static void createOneToOneRecord() {
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		
		Student s1 = new Student("aditya", "aditya@gmail.com", "1212112");
		Address a1 = new Address("kharghar", "MH");
		
		s1.setAddress(a1);
		
		session.save(s1);
		session.save(a1);
		
		session.getTransaction().commit();
		session.close();
	}

}
