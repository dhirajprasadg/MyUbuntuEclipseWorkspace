package corejava.deadloc;

public class DeadLockExa {
	

	public static void main(String[] args) {
		final  String name1 = " Dk ";
		final  String name2 = " Dk2 ";
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (name1) {
					System.out.println("Thread 1 reading :" + name1);
					try {
						Thread.sleep(3533);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (name2) {
						System.out.println("Thread 1 reading :" + name2);
						
					}

				}
			
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (name2) {
					System.out.println("Thread 1 reading :" + name1);
					try {
						Thread.sleep(3533);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (name1) {
						System.out.println("Thread 1 reading :" + name2);
						
					}

				}
			
			}
		});

		t1.start();
		t2.start();

	}

}
