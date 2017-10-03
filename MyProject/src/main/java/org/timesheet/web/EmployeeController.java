package org.timesheet.web;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.timesheet.domain.Employee;
import org.timesheet.service.dao.EmployeeDao;
import org.timesheet.web.exceptions.EmployeeDeleteException;
/*https://vrtoonjava.wordpress.com/2012/06/17/part-3-dao-and-service-layer/
*/
@Controller
@RequestMapping("/employees")
public class EmployeeController {
	public static Logger log = LogManager.getLogger(EmployeeController.class); 
	private EmployeeDao employeeDao;

	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	@RequestMapping(method = RequestMethod.GET)
    public String showEmployees(Model model) {
		log.debug("showEmployees");
        List<Employee> employees = employeeDao.list();
        Collections.sort(employees);
        Collections.reverse(employees);
        model.addAttribute("employees", employees);
 
        return "employees/list";
    }	
	
	@RequestMapping(value = "find/{id}", method = RequestMethod.GET)
	public String findEmployee(@PathVariable("id") long id, Model model) {
		log.debug("Find or getEmployee");		

		Employee employee = employeeDao.find(id);
		log.debug(" get gave result /// " + employee.toString());		
	    model.addAttribute("employee", employee);
	 
	    return "employees/view";
	}
	
	@RequestMapping(value = "load/{id}", method = RequestMethod.GET)
	public String loadEmployee(@PathVariable("id") long id,Model model) {
		log.debug("LoadEmployee");
		Employee employee1=null;
		try{
		 Employee e1 = employeeDao.load(id);	
		 employee1 =(Employee) e1.clone();	
		 //System.out.println(" Load gave result /// " + employee1);
		//	log.debug(" Load gave result /// " + employee1.toString());
		}catch(Exception e){
			log.debug(" error with loading " );
			 e.printStackTrace();
		}
		
		
	    model.addAttribute("employee", employee1);
	 
	    return "employees/view";
	}
	
	
	@RequestMapping(value = "preparedstEmployee/{id}", method = RequestMethod.GET)
	public String preparedstEmployee(@PathVariable("id") long id, Model model) {
		log.debug("preparedstEmployee");
				
		Employee employeed = employeeDao.preparedst(id);
	    model.addAttribute("employee", employeed);
	 
	    return "employees/view";
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateEmployee(@PathVariable("id") long id, Employee employee) {
		log.debug("updateEmployee");
		employee.setId(id);
	    employeeDao.update(employee);
	 
	    return "redirect:/employees";
	}
	
	/**
	 * Deletes employee with specified ID
	 * @param id Employee's ID
	 * @return redirects to employees if everything was ok
	 * @throws EmployeeDeleteException When employee cannot be deleted
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("id") long id)
	        throws EmployeeDeleteException {
		log.debug("deleteEmployee");
	    Employee toDelete = employeeDao.find(id);
	    boolean wasDeleted = employeeDao.removeEmployee(toDelete);
	 
	    if (!wasDeleted) {
	        throw new EmployeeDeleteException(toDelete);
	    }
	 
	    // everything OK, see remaining employees
	    return "redirect:/employees";
	}
	
	@RequestMapping(params = "new", method = RequestMethod.GET)
	public String createEmployeeForm(Model model) {
		log.debug("createEmployeeForm");
		model.addAttribute("employee", new Employee());
	    return "employees/new";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String addEmployee(Employee employee) {
		log.debug("addEmployee");
		employeeDao.add(employee);
	 
	    return "redirect:/employees";
	}
	
	/**
	 * Handles EmployeeDeleteException
	 * @param e Thrown exception with employee that couldn't be deleted
	 * @return binds employee to model and returns employees/delete-error
	 */
	@ExceptionHandler(EmployeeDeleteException.class)
	public ModelAndView handleDeleteException(EmployeeDeleteException e) {
	    ModelMap model = new ModelMap();
	    model.put("employee", e.getEmployee());
	    return new ModelAndView("employees/delete-error", model);
	}
	
}