package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import negocio.entities.Profesor;

public class Test {

	public static void main(String[]args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Profesor.class).buildSessionFactory();
		Session session=factory.openSession();
		try {
			Profesor profe=new Profesor("01234567D", "saHOLA", "dswdPO", false);
			session.beginTransaction();
			session.save(profe);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}
}
