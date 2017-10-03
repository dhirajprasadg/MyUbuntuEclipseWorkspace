package jdbc.cacheing.service;

import java.util.Map;

import jdbc.cacheing.dao.EmployeeDAO;

public class EmployeeService {

	EmployeeDAO empdao;

	public Map<String,String> getEmployeeSer() throws Exception {
		empdao = new EmployeeDAO();
		return empdao.getEmployeedao();
	}
}
