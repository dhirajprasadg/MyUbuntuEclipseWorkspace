package jdbc.cacheing.cash;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;

public class EmployeeCash {
	private Map<String, String> hm;
	String url = "jdbc:mysql://localhost:3306/testDB";
	Connection con = null;
	
	public EmployeeCash(){		
		hm = new HashMap<>();		
		 
	}

	public Map<String,String> getEmployee(){
		if(!(hm.isEmpty())){
		System.out.println("Data used from map");
			return getHm();		
		}else{			
			try {
				polulatedata();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return hm;
		}
	}
	
	
	private void polulatedata() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = (Connection) DriverManager.getConnection(url, "root", "password");
		java.sql.Statement st = con.createStatement();
		ResultSet set = st.executeQuery("select * from testDB.employee");

		while (set.next()) {
			hm.put(set.getString(2), set.getString(3));
		}

	}


	public Map<String, String> getHm() {
		return hm;
	}


	
	
	
	
}
