package headfirst.methodfactory;

public class ChicagoStyleVeggiPizza extends Pizza{
	public ChicagoStyleVeggiPizza(){
		name = "Chicago Style Veggie Pizza";
		dough = "Extra thick crust Dough";
		sauce = "Plum Tomato Sauce";

		toppings.add("Shredded Mozzarella cheese");

	}
	void cut(){
		System.out.println("Cutting the pizza into square slices");
	}
}
