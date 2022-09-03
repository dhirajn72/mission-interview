package headfirst.methodfactoryabstract;

public class NYPizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
		if("cheese".equals(item)){
			pizza = new CheesePizza(pizzaIngredientFactory);
			pizza.setName("New York Style Cheese Pizza");
		}
		else if("veggie".equals(item)){
			pizza = new VeggiesPizza(pizzaIngredientFactory);
			pizza.setName("New York Style Veggie Pizza");
		}
		else if("clam".equals(item)){
			pizza = new ClamePizza(pizzaIngredientFactory);
			pizza.setName("New York Style Clam Pizza");
		}
		else if("pepperoni".equals(item)){
			pizza = new PepperoniPizza(pizzaIngredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
		}
		return pizza;
	}
}
