package corejava.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Employee {

	private int id;
	private String name;
	private String comp;
	private List<String> names = new ArrayList<String>();
    private Random random = new Random();
	
    public void addname() {
		Thread ma = new Thread(new Runnable(){
			@Override
			public void run() {
				process();			
				
			}
			
		});
		Thread maa = new Thread(new Runnable(){
			@Override
			public void run() {
				process();			
				
			}
			
		});
		ma.start();
		maa.start();
		try {
			ma.join();
			maa.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
    	System.out.println(" Added Number : " + names.toString());	
	}
    
    public void process(){
    	for(int i=0; i<2;i++){
    		stageone();
    		stagetwo();		
    	}    
    }
    
    public void stageone(){
    	Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				names.add("dk1"+random.nextInt());		
			}
    		
    	}); 	
    	t1.start();
    	try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public void stagetwo(){

    	Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				names.add("dk"+random.nextInt());		
			}
    		
    	});
    	t2.start();
   	}
	
	
	
	
	
	
	
	
	public Employee() {
		
	}	
	
	public Employee(int id, String name, String comp) {
		this.id = id;
		this.name = name;
		this.comp = comp;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
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

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}




	/*
	 * @Override public int hashCode() {
	 * System.out.println("===========HashCode======="); final int prime = 31;
	 * int result = 1; System.out.println(" Result1 : " + result); result =
	 * prime * result + id; System.out.println(" Result2 : " + result); result =
	 * prime * result + ((name == null) ? 0 : name.hashCode());
	 * System.out.println(" Result3 : " + result);
	 * System.out.println("===========HashCode======="); return result; }
	 */

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * 
	 * result = prime * result + ((comp == null) ? 0 : comp.hashCode());
	 * //System.out.println(" Result1 : " + result);
	 * 
	 * result = prime * result + id; //System.out.println(" Result2 : " +
	 * result);
	 * 
	 * result = prime * result + ((name == null) ? 0 : name.hashCode());
	 * System.out.println(" HashCode function called : " + result);
	 * 
	 * return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) { return
	 * true; } if (obj == null) { return false; } if (!(obj instanceof
	 * Employee)) { return false; } Employee other = (Employee) obj; if (comp ==
	 * null) { if (other.comp != null) { return false; } } else if
	 * (!comp.equals(other.comp)) { return false; } if (id != other.id) { return
	 * false; } if (name == null) { if (other.name != null) { return false; } }
	 * else if (!name.equals(other.name)) { return false; } return true; }
	 * 
	 */

}
