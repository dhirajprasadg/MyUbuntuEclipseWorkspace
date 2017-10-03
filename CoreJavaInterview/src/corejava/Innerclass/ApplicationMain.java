package corejava.Innerclass;

public class ApplicationMain {
	private String classname ="applicatMian class";
     
	
	public static void applicationmainmethod(Associate am){
		System.out.println(" applicaiton main : " + am.MiddleName);
		am.nonstatic();
	}
	public static void main(String[] args) {
       
		Executive exe = new Associate();
		//exe.outmethod(); it will throw compile time error
		Associate.staticmehtod();
		Associate as = new Associate();
		Associate[] ass = {as};
		as.exectutive();
		
		ApplicationMain ama = new ApplicationMain();
		ApplicationMain.applicationmainmethod(as);
		
		StringBuffer str = new StringBuffer();
		str.append("Dhiraj");
		str.reverse();
		System.out.println("----Reverse: " + str);
		System.out.println(" Name : " + as.getName());
		as.outmethod();
		System.out.println("==========================");
		for(int i =0; i<5 ; i++){
		System.out.println( " Math random " + Math.random());
			if(i==2){
				continue;
			}
		System.out.println(" Number are : " + i);
		 if(i==4){
			 break;
		 }
		 System.out.println(" Nummber are after break : " + i);
		}

	}

	
	
}
