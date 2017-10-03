package jdbc.cacheing.application;

import java.util.Iterator;
import java.util.Map;

import jdbc.cacheing.service.EmployeeService;

public class MainClass {

	public static void main(String[] args) throws Exception {

		EmployeeService emps = new EmployeeService();
		Map<String, String> em = emps.getEmployeeSer();
		printemp(em);
		printemp(emps.getEmployeeSer());
		Thread.sleep(4444);

		EmployeeService emps2 = new EmployeeService();
		Map<String, String> em2 = emps2.getEmployeeSer();
		printemp(em2);
		Thread.sleep(4444);
	}

	private static void printemp(Map<String, String> hm) {
		for (Map.Entry<String, String> en : hm.entrySet()) {
			System.out.println(" " + en.getKey() + " -- " + en.getValue());
		}

		System.out.println("=====================================");

		Iterator it = hm.keySet().iterator();
		synchronized (hm) {
			while (it.hasNext()) {
				String key = (String) it.next();
				System.out.println(" key : " + key + " // Value : " + hm.get(key));
			}
		}

	}

}
