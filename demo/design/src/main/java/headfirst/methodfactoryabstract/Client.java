package headfirst.methodfactoryabstract;

public class Client {
	public static void main(String[] args){
		PizzaStore pizzaStore = new NYPizzaStore();
		Pizza pizza = pizzaStore.orderPizza("cheese");
		System.out.println("Fully prepared pizza : " + pizza);
	}
}
