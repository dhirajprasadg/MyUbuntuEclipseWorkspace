package myshopingcart.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateUtility {
	private static Logger log = LogManager.getLogger(HibernateUtility.class);
	public static SessionFactory sesf;
	public static Session ses;

	public static SessionFactory getSesf() {
		Throwable t = new Throwable();
		StackTraceElement[] te = t.getStackTrace();
		for (int i = 0; i < te.length - 1; i++) {
			log.error(" && Class Name : " + te[i].getClassName() + " // Method : \"" + te[i].getMethodName() + "\" is Called from - \"" + te[i + 1].getMethodName() + "\"  Method " + " at Line Number : " + te[i + 1].getLineNumber() + " in Class " + te[i+1].getClassName());
		}		
		return sesf;
	}

	public static void setSesf(SessionFactory sesf) {
		Throwable t = new Throwable();
		StackTraceElement[] te = t.getStackTrace();
		for (int i = 0; i < te.length - 1; i++) {
			log.error("&& Class Name : " + te[i].getClassName() + " // Method : \"" + te[i].getMethodName() + "\" is Called from - \"" + te[i + 1].getMethodName() + "\"  Method " + " at Line Number : " + te[i + 1].getLineNumber() + " in Class " + te[i+1].getClassName());
		}
		
		HibernateUtility.sesf = sesf;
	}

	private HibernateUtility() {
	}

	public static synchronized Session openSession() {
		log.error(" ------------ Open session called -------------- ");
		Throwable t = new Throwable();
		StackTraceElement[] te = t.getStackTrace();
		for (int i = 0; i < te.length - 1; i++) {
			log.error("&& Class Name : " + te[i].getClassName() + " // Method : \"" + te[i].getMethodName() + "\" is Called from - \"" + te[i + 1].getMethodName() + "\"  Method " + " at Line Number : " + te[i + 1].getLineNumber() + " in Class " + te[i+1].getClassName());
		}
		
		
		if (ses==null) {
			ses = createNewSession();
			return ses;
		} else {
			log.error(" ------------ Returning existing session -------------- " + ses.isConnected() + "  " + ses.toString());
			return ses;
		}

	}

	public static Session createNewSession() {
		Throwable t = new Throwable();
		StackTraceElement[] te = t.getStackTrace();
		for (int i = 0; i < te.length - 1; i++) {
			log.error("&& Class Name : " + te[i].getClassName() + " // Method : \"" + te[i].getMethodName() + "\" is Called from - \"" + te[i + 1].getMethodName() + "\"  Method " + " at Line Number : " + te[i + 1].getLineNumber() + " in Class " + te[i+1].getClassName());
		}
		
		log.error(" ------------ Creating fresh session -------------- ");
		ses = sesf.openSession();
		return ses;
	}

	public static void closeSession() {
		Throwable t = new Throwable();
		StackTraceElement[] te = t.getStackTrace();
		for (int i = 0; i < te.length - 1; i++) {
			log.error("&& Class Name : " + te[i].getClassName() + " // Method : \"" + te[i].getMethodName() + "\" is Called from - \"" + te[i + 1].getMethodName() + "\"  Method " + " at Line Number : " + te[i + 1].getLineNumber() + " in Class " + te[i+1].getClassName());
		}
		
		log.error(" ------------ closing session session -------------- ");
		sesf.close();
	}

	public static Session getCurrentSession() {
		// TODO Auto-generated method stub
		return null;
	}

}
