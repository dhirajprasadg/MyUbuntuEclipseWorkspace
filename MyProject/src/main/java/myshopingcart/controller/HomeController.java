package myshopingcart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myshopingcart.beans.Associate;
import myshopingcart.beans.User;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	public static Logger log = LogManager.getLogger(HomeController.class);
	public HttpSession ses;

	public HomeController() {
		log.error(" Default Constructor of Home controller");
	}

	@Autowired
	public  Associate asc;

	@RequestMapping(value = "logins", method = RequestMethod.POST)
	public ModelAndView homepage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		asc.setName(user);
		log.error(" // inside homepage method / User logged in : " + user);
		ModelAndView mv = new ModelAndView();
		if (user.trim().equalsIgnoreCase("dhiraj")) {
			ses = req.getSession(true);
			ses.setAttribute("associate", asc);
			User loggedin = (User) ses.getValue("associate");
			log.error(" // Session setup for  : " + loggedin.getName());
			mv.setViewName("home");
		} else {
			log.error(" //  moving to loginagain page ");
			mv.setViewName("loginagain");
		}

		return mv;

	}

	
	@RequestMapping(value = "createaccount", method = RequestMethod.POST)
	public ModelAndView createaccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		ModelAndView mv = new ModelAndView();
	
		return mv;
		
	}
	
	
}
