package headfirst.facade;

public class HomeTheaterFacade {
	private Amplifier amplifier;
	private Tuner tuner;
	private DvdPlayer dvdPlayer;
	private CdPlayer cdPlayer;
	private Projector projector;
	private TheaterLights lights;
	private Screen screen;
	private PopcornPopper popper;

	public HomeTheaterFacade(Amplifier amplifier, Tuner tuner, DvdPlayer dvdPlayer, CdPlayer cdPlayer, Projector projector, TheaterLights lights, Screen screen, PopcornPopper popper) {
		this.amplifier = amplifier;
		this.tuner = tuner;
		this.dvdPlayer = dvdPlayer;
		this.cdPlayer = cdPlayer;
		this.projector = projector;
		this.lights = lights;
		this.screen = screen;
		this.popper = popper;
	}

	public void watchMovie(String movie){
		System.out.println("Ready to watch movie : " + movie);
		popper.on();
		popper.pop();
		lights.dim(10);
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amplifier.on();
		amplifier.setDvd(dvdPlayer);
		amplifier.setVolume(6);
		dvdPlayer.on();
		dvdPlayer.play();

	}
	public void endMovie(){
		System.out.println("Shutting movie theater down");
		popper.off();
		lights.on();
		screen.up();
		projector.off();
		amplifier.off();
		dvdPlayer.stop();
		dvdPlayer.eject();
		dvdPlayer.off();
	}
}
