package dhiraj.webapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Employee {
    
	private int id;
    private String name;
    
	public Employee() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
