package myshopingcart.dao.impl;

import java.util.List;

import myshopingcart.beans.Login;
import myshopingcart.dao.LoginDAO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("LoginDAOImpl")
public class LoginDAOImpl implements LoginDAO{
	public static Logger log = LogManager.getLogger(LoginDAOImpl.class);
	
	@Autowired
	private SessionFactory mySessionFactoryy;
/*
	public void setMySessionFactoryy(SessionFactory mySessionFactoryy) {
		this.mySessionFactoryy = mySessionFactoryy;
	}
*/
	//@Transactional(value = "transactionManager")
	public Login getUserDetails(String userName) {
		
		Throwable t = new Throwable();
		StackTraceElement[] te = t.getStackTrace();
		for (int i = 0; i < te.length - 1; i++) {
			log.error("&& Class Name : " + te[i].getClassName() + " // Method : \"" + te[i].getMethodName() + "\" is Called from - \"" + te[i + 1].getMethodName() + "\"  Method " + " at Line Number : " + te[i + 1].getLineNumber() + " in Class " + te[i+1].getClassName());
		}
		
		
		log.debug("get detail for : " + userName);
		Login login = null;
		log.debug("my session factory check   // mySessionFactoryy :" + this.mySessionFactoryy);
		try {

			Session currentSession = this.mySessionFactoryy.openSession();

			Query query = currentSession.createQuery("from Login where userName='" + userName + "'");
			log.debug("Query passing " + query);
			List list = query.list();
			log.debug(" List of User : " + list);
			if (!list.isEmpty()) {
				login = (Login) list.get(0);
			}
			return login;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional(value = "transactionManager")
	public void AddUserDetails(Login login) {
		int id = login.getId();
		log.debug(" Id = " + id);

		try {

			Session currentSession = mySessionFactoryy.openSession();
			Transaction tx = currentSession.beginTransaction();
			currentSession.saveOrUpdate(login);
			tx.commit();
			log.debug("succefully added the user");

		} catch (Exception e) {
			log.debug(" Exception to add add user");
			e.printStackTrace();
		}
	}

}
