package headfirst.decorator.v1;

public class Mocha extends CondimentDecorator{
	private Beverage beverage;
	Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	@Override
	public double cost() {
		return this.beverage.cost() + 2.89;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() +", Mocha";
	}
}
