package pattern.decorator;

public class Tomatos extends PizzaTopping {

	public Tomatos(Pizza pi) {
		this.piza=pi;
	}

	@Override
	public void description() {
		System.out.println("Tomatos");
	}

	@Override
	public int cost() {
		return piza.cost() + 2;
	}

	
}
