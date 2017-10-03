package corejava.interfaAbst;

public class ServiceClass {
	public static void main(String[] args) {
		Address had = new HomeAddress();
		had.display();
		
		Investment hm = new HomeInvestment(); 
	    hm.getdetail();
	    hm.addAmount(44);
	
	}
}
