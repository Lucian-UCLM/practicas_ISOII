package persistencia;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public abstract class AbstractEntityDAO<E> {

	private Class<E> entityClass;
	private SessionFactory sessionfactory;
	List<E>list = new ArrayList<>();
	
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
		sesion.close();
	}
	
	public void update(E entity) {
		Session sesion=getSession();
		sesion.beginTransaction();
		sesion.update(entity);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public void saveOrUpdate(E entity) {
		Session sesion=getSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(entity);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public void delete(E entity) {
		Session sesion=getSession();
		sesion.beginTransaction();
		sesion.delete(entity);
		sesion.getTransaction().commit();
		sesion.close();
	}
	public List<E> showAll() {
		Session sesion=getSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("from " + entityClass.getSimpleName(), entityClass);
		list = (List<E>)query.list();
		sesion.getTransaction().commit();
		sesion.close();
		return list;
	}
	
	public List<E> showAllWhere(String where) {
		Session sesion=getSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("from " + entityClass.getSimpleName()+" where " + where, entityClass);
		list = (List<E>)query.list();
		sesion.getTransaction().commit();
		sesion.close();
		return list;
	}
	
	public Object show(String id) {
		Session sesion=getSession();
		sesion.beginTransaction();
		Object entidad = sesion.get(entityClass, id);
		sesion.getTransaction().commit();
		sesion.close();
		return entidad;
	}
	
	public Object show(int id) {
		Session sesion=getSession();
		sesion.beginTransaction();
		Object entidad = sesion.get(entityClass, id);
		sesion.getTransaction().commit();
		sesion.close();
		return entidad;
	}
	
	public void operation() {
		throw new UnsupportedOperationException();
	}
}