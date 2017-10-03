package jdbc.cacheing.dao;
import java.util.Map;

import jdbc.cacheing.cash.EmployeeCash;

public class EmployeeDAO {

	public Map<String, String> getEmployeedao() {
		EmployeeCash eca = new EmployeeCash();
		
		return eca.getEmployee();
		
	
	}

}
