package headfirst.decorator.v1;

public class Soy extends CondimentDecorator{
	private Beverage beverage;
	Soy(Beverage beverage){
		this.beverage = beverage;
	}
	@Override
	public double cost() {
		return this.beverage.cost() + 1.71;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() +", Soy";
	}
}
