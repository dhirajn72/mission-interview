package headfirst.methodfactory;

public class NYPizzaStore  extends PizzaStore{
	@Override
	public Pizza createPizza(String type) {
		if("cheese".equals(type))
			return new NYStyleCheesePizza();
		else if("veggi".equals(type))
			return new NYStyleVeggiPizza();
		return null;
	}
}
