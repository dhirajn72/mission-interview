package headfirst.methodfactory;

public class ChicagoStyleCheesePizza extends Pizza{
	public ChicagoStyleCheesePizza(){
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra thick crust Dough";
		sauce = "Plum Tomato Sauce";

		toppings.add("Shredded Mozzarella cheese");

	}
	void cut(){
		System.out.println("Cutting the pizza into square slices");
	}
}
