package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractEntityDAO<E> {

	private Class<E> entityClass;
	private SessionFactory sessionfactory;
	
	public AbstractEntityDAO(Class<E> entityClass) {
		super();
		this.entityClass = entityClass;
		this.sessionfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(entityClass).buildSessionFactory();
	}

	protected Session getSession() {
		return this.sessionfactory.openSession();
	}
	
	public void save(E entity) {
		Session sesion=getSession();
		sesion.beginTransaction();
		sesion.save(entity);
		sesion.getTransaction().commit();
	}
	
	public void update(E entity) {
		Session sesion=getSession();
		sesion.beginTransaction();
		sesion.update(entity);
		sesion.getTransaction().commit();
	}

	public void saveOrUpdate(E entity) {
		Session sesion=getSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(entity);
		sesion.getTransaction().commit();
	}

	public void delete(E entity) {
		Session sesion=getSession();
		sesion.beginTransaction();
		sesion.delete(entity);
		sesion.getTransaction().commit();
	}

	public void operation() {
		throw new UnsupportedOperationException();
	}

}