package headfirst.facade;

public class Client {
	public static void main(String[] args){
		HomeTheaterFacade facade = new HomeTheaterFacade(new SonyAmplifier(), null, null, null, null, null, null, null);
		facade.watchMovie("Starwars");
		facade.endMovie();
	}
}
