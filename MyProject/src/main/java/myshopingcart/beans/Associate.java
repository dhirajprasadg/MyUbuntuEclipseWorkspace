package myshopingcart.beans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Associate {
	public static Logger log = LogManager.getLogger(Associate.class);

	public Associate() {
		log.error("associate constructor invoked");
	}

	private String name;
	private int id;
	

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setName(String user) {
		// TODO Auto-generated method stub
		
	}
}