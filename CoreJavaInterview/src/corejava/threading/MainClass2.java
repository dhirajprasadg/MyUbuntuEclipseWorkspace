package corejava.threading;

public class MainClass2 {
    public int count;
    
    public synchronized void countincrease(){
    	count++;
    }
    
    public static void main(String[] args) {
		MainClass2 mc2 = new MainClass2();
		mc2.dowork();
		Employee e1 = new Employee();
		e1.addname();
	}
	
	public void dowork(){
	 	Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				for(int i=0;i<2000;i++){
					countincrease();
				}
				
			}	 		
	 	});
	 	
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				for(int i=0;i<2000;i++){
					countincrease();
				}
				
			}	 		
	 	});
	 	t1.start();
	 	t2.start();	 	
	 	try {
	 		t1.join();
	 		t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 	System.out.println(" Count : " + count);	
	}
}
