package design.pattern.decorator;

public class ChineeseFood extends FoodDecorator{

	public ChineeseFood(Food food) {
		super(food);
	}

	@Override
	public String prepareFood() {
		return super.prepareFood() + " Chineese";
	}

	@Override
	public double foodPrice() {
		return super.foodPrice() + 44;
	}

	
	
	
}
