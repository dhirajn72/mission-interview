package headfirst.methodfactory;

public class ChicagoPizzaStore extends PizzaStore{
	@Override
	public Pizza createPizza(String type) {
		if("cheese".equals(type))
			return new ChicagoStyleCheesePizza();
		else if("veggi".equals(type))
			return new ChicagoStyleVeggiPizza();
		return null;
	}
}
