package corejava.interfaAbst;

public abstract class Investment {
        private int amount;
	
     	public abstract void getdetail();
     	
     	public void addAmount(int i){
     	
     		this.amount=i;
     		System.out.println(" Added Amount : " + this.amount);
     	}
	
}
