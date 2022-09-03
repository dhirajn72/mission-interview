package headfirst.facade;

public interface Amplifier {
	void on();

	void setDvd(DvdPlayer dvdPlayer);

	void setVolume(int i);

	void off();
}
