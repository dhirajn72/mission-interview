package headfirst.decorator.v2;

public class Soy extends Condimentary{
	private Beverage beverage;
	Soy(Beverage beverage){
		this.beverage = beverage;
	}
	@Override
	public double cost() {
		return beverage.cost() + 0.43;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}
}
