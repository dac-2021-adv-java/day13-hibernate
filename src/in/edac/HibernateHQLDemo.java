package in.edac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Student;

public class HibernateHQLDemo {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		demo1();
	}
	
	
	public static void demo1() {
		Session session =  sessionFactory.openSession();
		
		String sql = "SELECT * FROM STUDENT";
		List<Student> list =  session.createNativeQuery(sql, Student.class).list();
		
		list.stream().map(Student::getName).forEach(System.out::println);
		
		session.close();
	}
	
	
	
	
	
}
