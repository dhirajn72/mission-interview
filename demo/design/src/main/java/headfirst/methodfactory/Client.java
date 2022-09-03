package headfirst.methodfactory;

public class Client {
	public static void main(String[] args){
		PizzaStore  nyStore = new NYPizzaStore();
		Pizza  pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza.getName());

		System.out.println("-------------");
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		Pizza pizza1 = chicagoStore.orderPizza("cheese");
		System.out.println("John cena ordered a "+ pizza1.getName());

	}
}
