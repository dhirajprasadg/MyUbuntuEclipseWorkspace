package corejava.overloading;

public class Payment implements Cloneable {
	private String amou;
	
	public Payment(String amou) {
		this.amou = amou;
	}

	@Override
	public Payment clone() throws CloneNotSupportedException {		
		
		return (Payment)super.clone();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	private String makePayment(int amount) {

		amou = String.valueOf(amount);
		return amou;
	}

	private int makePayment(int amount,String st,String s) {

		amou = String.valueOf(amount);
		return amount;
	}

	private String makePayment(int amount,String st) {

		amou = String.valueOf(amount);
		return amou;
	}
	
	private String makePayment(String st,int amount) {

		amou = String.valueOf(amount);
		return amou;
	}


	@Override
	public String toString() {
		return "Payment [amou=" + amou + "]";
	}
	
	
}
