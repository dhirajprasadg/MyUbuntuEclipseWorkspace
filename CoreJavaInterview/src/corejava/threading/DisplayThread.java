package corejava.threading;

import java.util.Map;
import java.util.Map.Entry;

public class DisplayThread {
    public void startsecondthread(){
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
			  
			      try {
						Thread.currentThread().sleep(2244);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
		},"mythread 2");
		t2.start();

    }
	
	public static void main(String[] args) {
	      
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				  new DisplayThread().startsecondthread();	  
			try {
				Thread.currentThread().sleep(2555);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			
		},"mythread 1");
		t1.start();
      
		
		System.out.println("Start ===========================================");	
		
		Thread[] t = new Thread[Thread.activeCount()];
		
		int no = Thread.enumerate(t);

		for(int i=0; i<no; i++){
		System.out.println("-----------");
			Thread ab = t[i];
			Map<Thread ,StackTraceElement[]> st = ab.getAllStackTraces();
			for(Entry<Thread ,StackTraceElement[]> ste : st.entrySet()){
				Thread name = ste.getKey();
				System.out.println("    @@ Thread Name : " + name.getName() + " / Group : " + name.getThreadGroup());
			    for(StackTraceElement stee : ste.getValue()){
			    	System.out.println( "      Stack Ele --" + stee.getMethodName());
			    }
			}
			
		}
		System.out.println("End===========================================");
	
	
		
	}// main method end
	
}
