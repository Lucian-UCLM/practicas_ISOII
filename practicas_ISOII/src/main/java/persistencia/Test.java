package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import negocio.entities.Profesor;

public class Test {

	public static void main(String[]args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Profesor.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			System.out.println("v");
			Profesor profe=new Profesor("01234567A", "Pablo", "Martínez Sosa", false);
			session.beginTransaction();
			System.out.println("dd");
			session.save(profe);
			
			session.getTransaction().commit();
			System.out.println("fefea");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}
}
