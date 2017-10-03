package org.timesheet.service.impl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.timesheet.domain.Employee;
import org.timesheet.service.GenericDao;
import org.timesheet.web.EmployeeController;

import com.mysql.jdbc.Connection;

import java.lang.reflect.ParameterizedType;

/**
 * https://vrtoonjava.wordpress.com/2012/06/17/part-3-dao-and-service-layer/
 * Basic DAO operations dependent with Hibernate's specific classes
 * 
 * @see SessionFactory
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class HibernateDao<E, K extends Serializable> implements GenericDao<E, K> {
	public static Logger log = LogManager.getLogger(HibernateDao.class);
	private SessionFactory mySessionFactory;
	protected Class<? extends E> daoType;

	@SuppressWarnings("unchecked")
	public HibernateDao() {
		daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.mySessionFactory = sessionFactory;
	}

	protected Session currentSession() {
		return mySessionFactory.getCurrentSession();
	}

	@Override
	public void add(E entity) {
		currentSession().save(entity);
	}

	@Override
	public void update(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(E entity) {
		currentSession().delete(entity);
	}

	@Override
	public E find(K key) {
		log.debug(" find called with id : " + key);
		return (E) currentSession().get(daoType, key);
	}

	@Override
	public E load(K key){
		log.debug(" Load called with id : " + key);
		Session sessions=currentSession();
		System.out.println("Session received : " + sessions);
		System.out.println("-----------");
		Employee emp = (Employee)sessions.load(daoType, key);
		//System.out.println("Employee in load hib : " + emp); 
		System.out.println("-----------");
		return (E)emp;
	}
	@Override
	public Employee preparedst(K key){
		Session session=mySessionFactory.openSession();
		SessionFactoryImplementor sessionFactoryImplementation = (SessionFactoryImplementor) session.getSessionFactory();
		ConnectionProvider connectionProvider = sessionFactoryImplementation.getConnectionProvider();
		java.sql.Connection connection = null;
		try {
			   connection = connectionProvider.getConnection();

				String sql="SELECT * FROM employee WHERE id=?";
				PreparedStatement statement=connection.prepareStatement(sql);
				try{
					System.out.println(" Statement to string : " + statement.toString());
				}catch (Exception e){
					e.printStackTrace();
				}
				statement.setInt(1, (Integer) key);
				
				try{
					System.out.println("  Statement to string : " + statement.toString());
				}catch (Exception e){
					e.printStackTrace();
				}
				ResultSet rs =statement.executeQuery();
				while(rs.next()){
					System.out.println("  RS to string 1 : " + rs.getString(1));
					System.out.println("  RS to string 2 : "+rs.getString(2));
					System.out.println("  RS to string 3 : "+rs.getString(3));
				}
		} catch(Exception e){
			System.out.println("Excepion happened in hibernate dao");
			e.printStackTrace();
		}
		    		
		return new Employee();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<E> list() {
		
		
		return currentSession().createCriteria(daoType).list();
	}
}