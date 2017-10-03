package myshopingcart.util;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

public class CustomContextLoaderListener extends ContextLoaderListener{
 public static Logger log = LogManager.getLogger(CustomContextLoaderListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		// This manually deregisters JDBC driver, which prevents Tomcat 7 from complaining about memory leaks wrto this class
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                log.error( String.format("deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
            	log.error(String.format("Error deregistering driver %s", driver), e);
            }

        }

	
	}

	
	
}
