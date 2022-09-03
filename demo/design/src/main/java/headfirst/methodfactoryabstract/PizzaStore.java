package headfirst.methodfactoryabstract;

public abstract class PizzaStore {
	public Pizza orderPizza(String type){
		Pizza pizza = createPizza(type);
		pizza.prepare();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	public abstract Pizza createPizza(String pizza);
}
