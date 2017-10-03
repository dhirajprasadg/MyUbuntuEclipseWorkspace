package myshopingcart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import myshopingcart.beans.JsonResponse;
import myshopingcart.beans.Login;
import myshopingcart.beans.User;
import myshopingcart.dao.HibernateUtility;
import myshopingcart.dao.LoginDAO;
import myshopingcart.dao.impl.LoginDAOImpl;
import myshopingcart.model.LoginModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
/*@EnableAspectJAutoProxy(proxyTargetClass = true)*/
public class LoginController {
	public static Logger log = LogManager.getLogger(LoginController.class);
	private List<User> userList = new ArrayList<User>();
	
	@Autowired
	public LoginDAO LoginDAO;
	

	/*public void setLoginDAOImpl(LoginDAOImpl loginDAOImpl) {
		LoginDAOImpl = loginDAOImpl;
	}*/
	
	@RequestMapping(value = "loginuser" ,method=RequestMethod.POST)
	public ModelAndView submit(ModelAndView modelMap, @ModelAttribute("loginFormfromindex") @Valid LoginModel loginModel) {
		String password = loginModel.getPassword();
		String userName = loginModel.getUserName();
		log.debug(" submit method invoked with User Name : " + userName + " and Password : " + password) ;
		if (password != null && userName != null) {
			log.debug("  User Name : " + userName + " and Password : " + password + " submitted by form") ;
			Login userDetails = LoginDAO.getUserDetails(userName);
			log.debug(" user retrived by db : " + userDetails.getUserName());
			log.debug(" Password retrived by db : " + userDetails.getPassword());
			if (userDetails != null && userDetails.getUserName().trim().equalsIgnoreCase(userName) && userDetails.getPassword().trim().equalsIgnoreCase(password)) {
				modelMap.addObject("userDetailss", userDetails);
				modelMap.setViewName("home");
				Map<String, Object> m = modelMap.getModel();
				Login lo = (Login) m.get("userDetailss");
				log.debug(" lo " + lo);
				log.debug(" Model object value received : " + lo.getUserName());
				return modelMap;
			} else {
				modelMap.addObject("error", "Invalid UserName / Password");
				modelMap.setViewName("Error");
				return modelMap;
			}
		} else {
			modelMap.addObject("error", "Invalid UserName / Password");
			modelMap.setViewName("Error");
			return modelMap;
		}
	}

	@RequestMapping(value = "addloginuser",method = RequestMethod.POST)
	public void addUser(ModelAndView modelMap, @ModelAttribute("addUserloginForm") Login login,HttpServletRequest req,HttpServletResponse resp) {
		
		log.debug(" addUser method invoked with with Login " + login.getUserName());
		String exist = login.getUserName();
		log.debug(" Searching for User Name : " + exist);

		Login exlogin = LoginDAO.getUserDetails(exist);
		String existing = null;
		if (exlogin == null) {

		} else {
			existing = exlogin.getUserName();
		}

		log.debug(" User exing in db " + existing);

		if (login.getUserName() != null && login.getPassword() != null && !exist.equalsIgnoreCase(existing)) {
			LoginDAO.AddUserDetails(login);
			req.getSession(true).setAttribute("UserAdded", login.getUserName());
			try {
			   req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
		} else {
			modelMap.addObject("error", "User exist");
		
		}
	}
	
	@RequestMapping(value = "/dousersearch", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody
	JsonResponse getUserList(@ModelAttribute(value = "user") User user, BindingResult resultin) {
		log.error("getUserList Method called");
		List<Login> loginList = new ArrayList<Login>();
		JsonResponse res = new JsonResponse();	
		ValidationUtils.rejectIfEmpty(resultin, "name", "Name can not be empty.");
		
		if (!resultin.hasErrors()) {
			try {
				Session se = HibernateUtility.openSession();		
			
				try {
					Query query = se.createQuery("from Login");
					// Query query =
					// se.createQuery("from Login where userName='" +
					// user.getName() + "'");
					log.debug("Query passing " + query);
					List list = query.list();
					log.debug("List Size : " + list.size() + " List of User : " + list);
					if (!list.isEmpty()) {
						res.setStatus("SUCCESS");
						for (int i = 0; i < list.size(); i++) {
							Login login = (Login) list.get(i);
							loginList.add(login);

						}
						log.debug("  User retrived and adding to resp : ");
						res.setResult(loginList);
						List<Login> loglisti = (List<Login>) res.getResult();
						Login lo = loglisti.get(0);
						log.error("  User Name retrived from Json response : " + lo.getUserName());
				      
						return res;
					} else {
						log.debug("  User list is empty");
						res.setStatus("FAIL");
						res.setResult(resultin.getAllErrors());
						return res;
					}

				} catch (Exception e) {
					e.printStackTrace();
				
					return res;
				}		
			
			} catch (Exception e) {
				e.printStackTrace();
		
				return res;
			}finally{
		
			}
		} else {
			log.debug(" Enter name to get result ");
			res.setStatus("FAIL");
			res.setResult(resultin.getAllErrors());
			return res;
		}

	}

	@RequestMapping("/looseSearch")
	public @ResponseBody
	List<Login> dosearch(@RequestParam("CHARS") String chars) {
		log.error("dosearch Method called : " + chars);
		Login us = new Login();
		List<Login> loginList = new ArrayList();
		Session se = HibernateUtility.openSession();
		try {
			Transaction tx = se.beginTransaction();
			try {
				Query query = se.createQuery("from Login");
				List list = query.list();
				log.debug("List Size : " + list.size() + " List of User : " + list);
				if (!list.isEmpty()) {
					for (int i = 0; i < list.size(); i++) {
						Login login = (Login) list.get(i);
						loginList.add(login);

					}
					log.debug("  User retrived fro db and returning  ");
					tx.commit();
					return loginList;
				} else {
					log.debug("  User list is empty");
					return loginList;
				}
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
				return loginList;
			}

		} finally {
			HibernateUtility.closeSession();

		}

	}
	
}
