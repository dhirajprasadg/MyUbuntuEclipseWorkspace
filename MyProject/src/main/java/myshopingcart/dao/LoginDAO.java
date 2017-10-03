package myshopingcart.dao;

import java.util.List;

import myshopingcart.beans.Login;
import myshopingcart.beans.User;
import myshopingcart.controller.LoginController;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



public interface LoginDAO {

	public static Logger log = LogManager.getLogger(LoginDAO.class);
	
	public Login getUserDetails(String userName);
	
	public void AddUserDetails(Login login);
	

}