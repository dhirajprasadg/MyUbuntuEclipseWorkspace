package ainterview.question;

public class ClassLoaderExample extends ClassLoader {

	public static void main(String[] args) {

		ClassLoaderExample cl = new ClassLoaderExample();
		System.out.println(" " + cl.getSystemClassLoader());
		System.out.println(" " + cl.getParent());
		System.out.println(" " + cl.getClass().getSuperclass().getClassLoader());
		String st = "dk";
		byte[] bt = st.getBytes();
		
		for (byte b : bt) {
			System.out.println(" Byte are : " + b);
		}
		Byte by = Byte.decode("1");
		System.out.println(" Byte wrapper : " + by.byteValue() + " Byte value as double : " + Byte.decode("1").doubleValue());
	 System.out.println(" super class of Byte :  " + Byte.class.getSuperclass());
	 Short.decode("3").intValue();
	 try{
		 System.out.println(" exception check : " + Double.compare(333333333333333333333333333333333.99, 11));
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 Double dou = new Double(666.44);
	@SuppressWarnings("static-access")
	Double dbl = dou.MAX_VALUE;
	try {
		Thread.sleep(44);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Double dblm = dou.MIN_VALUE;
	System.out.println(" Double Max Value : " + dbl);
	System.out.println(" Double Max Value : " + dblm);
	Integer i = new Integer(127);  
    byte x = i.byteValue();
    System.out.print(" Integer Byte value : " + x);
	
	
	}

}
