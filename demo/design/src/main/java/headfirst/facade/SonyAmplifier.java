package headfirst.facade;

public class SonyAmplifier implements Amplifier{
	private DvdPlayer dvdPlayer;
	@Override
	public void on() {
		System.out.println("SonyAmplifier is on");

	}

	@Override
	public void setDvd(DvdPlayer dvdPlayer) {
		this.dvdPlayer = dvdPlayer;
	}

	@Override
	public void setVolume(int i) {
		System.out.println("Volume is set to "+ i);
	}

	@Override
	public void off() {
		System.out.println("SonyAmplifier is shutting down");
	}
}
