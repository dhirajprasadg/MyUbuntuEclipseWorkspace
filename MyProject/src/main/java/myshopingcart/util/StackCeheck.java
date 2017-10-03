package myshopingcart.util;

import java.lang.reflect.Method;

import myshopingcart.dao.impl.LoginDAOImpl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class StackCeheck {

	public void che() {
		checking();
	}

	public void checking() {
		Throwable t = new Throwable();
		StackTraceElement[] te = t.getStackTrace();
		for (int i = 0; i < te.length - 1; i++) {
			System.out.println(" Class Name : " + te[i].getClassName() + " // Method : \"" + te[i].getMethodName() + "\" is Called from - \"" + te[i + 1].getMethodName() + "\"  Method " + " at Line Number : " + te[i + 1].getLineNumber());
		}
	}
	public static Logger log = LogManager.getLogger(StackCeheck.class);
	public static void main(String[] args) {
		Throwable t = new Throwable();
		StackTraceElement[] te = t.getStackTrace();
		for (int i = 0; i < te.length; i++) {
			System.out.println("&& Class Name : " + te[i].getClassName() + " // Method : \"" + te[i].getMethodName() + "\" is Called from - \"" + te[i ].getMethodName() + "\"  Method " + " at Line Number : " + te[i ].getLineNumber() + " in Class " + te[i].getClassName());
		}
	
	}

}
