package pattern.decorator;

public class Onion extends PizzaTopping{

	public Onion(Pizza pi) {
		this.piza=pi;
	}
	
	@Override
	public void description() {
		System.out.println("Onion Pizza");
	}

	@Override
	public int cost() {
		return piza.cost() + 2;
	}
	
}
