package corejava.threading;

import java.util.Scanner;

class Employe extends Thread{
	private transient boolean running= true;
	
	@Override
	public void run() {
		while(running){
			System.out.println(" Thread 2 is started "  + Thread.currentThread().getName());		
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void shutdown(){
		running =false;
	}
}

public class MainClass1 {

	public static void main(String[] args) {
		System.out.println(" Thread started : " + Thread.currentThread().getName());
		Thread t0 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<3 ;i++){
					System.out.println(" Thread 0 is started "  + Thread.currentThread().getName());	
					
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}

		});
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<3 ;i++){
					System.out.println(" Thread 1 is started "  + Thread.currentThread().getName());		
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				}
			

			}

		});

		//t0.start();
		//t1.start();
		
		Employe et2 = new Employe();
		et2.start();
		
        Scanner sc = new Scanner(System.in);
		sc.nextLine();
		et2.shutdown();
	}

}
