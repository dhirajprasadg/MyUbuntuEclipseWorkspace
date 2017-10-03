package dhiraj.webapp.mainclass;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import dhiraj.webapp.model.Employee;

public class MainApp {

	public static void main(String[] args) {
	
		Configuration conf = new Configuration().configure();
		conf.addResource("Employee.hbm.xml");
		SessionFactory sesf = conf.buildSessionFactory();
		
		Session ses = sesf.openSession();
		org.hibernate.Transaction tx = ses.beginTransaction();
		Employee e1 = new Employee();
		e1.setName("ddd");
		ses.save(e1);
		Employee emp = (Employee) ses.get(Employee.class, 1);

	}

}
