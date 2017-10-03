package design.pattern.decorator;

public class VegFood implements Food {

	@Override
	public String prepareFood() {
		return "Veg Food";
	}

	@Override
	public double foodPrice() {
		return 6;
	}

	
}
