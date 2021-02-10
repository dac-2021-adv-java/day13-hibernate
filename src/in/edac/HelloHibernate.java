package in.edac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Employee;
import in.edac.entity.Student;

public class HelloHibernate {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		addEmployee();
	}

	public static void addStudents() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Student std1 = new Student("rakesh", "rakesh@gmail.com", "1111111");
		Student std2 = new Student("prafulla", "prafulla@gmail.com", "1111112");
		Student std3 = new Student("sahil", "sahil@gmail.com", "1111113");
		Student std4 = new Student("punam", "punam@gmail.com", "1111114");
		Student std5 = new Student("vijay", "vijay@gmail.com", "1111115");
		Student std6 = new Student("roshni", "roshni@gmail.com", "1111116");

		session.save(std1);
		session.save(std2);
		session.save(std3);
		session.save(std4);
		session.save(std5);
		session.save(std6);

		session.getTransaction().commit();
		session.close();
	}
	
	
	public static void addEmployee() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Employee std1 = new Employee("cse", "google", "aditya");
		Employee std2 = new Employee("it", "whatsapp", "sumit");
		Employee std3 = new Employee("ece", "tesla", "prafulla");
		Employee std4 = new Employee("ee", "electric car", "meetali");
		Employee std5 = new Employee("me", "tesla adv", "viraj");
		Employee std6 = new Employee("civil", "hyperloop", "priyanka");

		session.save(std1);
		session.save(std2);
		session.save(std3);
		session.save(std4);
		session.save(std5);
		session.save(std6);

		session.getTransaction().commit();
		session.close();
	}
}
