package corejava.threading;

import java.util.Iterator;

public class MainClass {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (e1) {
					System.out.println(" Thread One is holding lock on Employee1 Object ");
					for (int i = 0; i < 5; i++) {
						try {
							Thread.sleep(100);
							e1.getNames().add("Dhiraj" + i);
							System.out.println(" Employee 1 - Added Name Dhiraj " + i);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				synchronized (e2) {
					System.out.println(" Thread One is holding lock on Employee2 Object ");
					for (int i = 0; i < 5; i++) {
						try {
							Thread.sleep(100);
							e2.getNames().add("Dhiraj" + i);
							System.out.println(" Employee 2 Added Name Dhiraj : " + i);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(e2){
				System.out.println(" Thread Two is holding lock on Employee Object ");
				Iterator<String> it = e2.getNames().iterator();
				while (it.hasNext()) {
					System.out.println(" Names are : " + it.next());
				}
				}

			}

		});

		t1.start();
		/*try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		t2.start();

	}

}
