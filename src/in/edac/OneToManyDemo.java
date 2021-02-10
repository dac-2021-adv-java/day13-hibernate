package in.edac;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Address;
import in.edac.entity.Project;
import in.edac.entity.Student;


public class OneToManyDemo {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		createRecord();
	}
	
	public static void readRecord() {
		Session session =  sessionFactory.openSession();
		
		Student st = session.find(Student.class, 15);
		st.getProjecList().stream().map(Project::getName).forEach(System.out::println);
		
		session.close();
	}
	
	public static void createRecord() {
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		
		Student s1 = new Student("aditya", "aditya@gmail.com", "1212112");
		Address a1 = new Address("kharghar", "MH");
		
		Project p1 = new Project("SMS", "IT");
		Project p2 = new Project("CMS", "IT");
		List<Project> projectList =  Arrays.asList(p1, p2);
		
		s1.setAddress(a1);
		s1.setProjecList(projectList);
		a1.setStudent(s1);
		p1.setStudent(s1);
		p2.setStudent(s1);
		
		session.save(s1);
		session.save(a1);
		
		session.save(p1);
		session.save(p2);
		
		session.getTransaction().commit();
		session.close();
	}

}
