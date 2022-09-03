package headfirst.decorator.v2;

public class Mocha extends Condimentary{
	private Beverage beverage;
	Mocha(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.83;
	}
}
