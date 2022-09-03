package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Observer {
	public static void main(String[] args){
		BellAlarm bellAlarm = new BellAlarm();
		new MorningAlarm(bellAlarm);
		new AfterNoonAlarm(bellAlarm);
		new EveningAlarm(bellAlarm);

		bellAlarm.execute();
	}
}

abstract class Alarm{
	protected BellAlarm bellAlarm;
	public abstract void ring();
}

class BellAlarm{
	private List<Alarm> observers = new ArrayList<>();
	public void add(Alarm alarm) {
		this.observers.add(alarm);
	}

	public void execute() {
		this.observers.stream().forEach(alarm -> alarm.ring());
	}
}

class MorningAlarm extends Alarm{
	public MorningAlarm(BellAlarm alarm){
		this.bellAlarm = alarm;
		this.bellAlarm.add(this);
	}
	@Override
	public void ring() {
		System.out.println("Morning alarm at 5:00 AM");
	}
}

class AfterNoonAlarm extends Alarm{
	public AfterNoonAlarm(BellAlarm alarm ){
		this.bellAlarm = alarm;
		this.bellAlarm.add(this);
	}
	@Override
	public void ring() {
		System.out.println("Afternoon alarm at 1:00 PM");
	}
}

class EveningAlarm extends Alarm{
	public EveningAlarm(BellAlarm alarm){
		this.bellAlarm = alarm;
		this.bellAlarm.add(this);
	}
	@Override
	public void ring() {
		System.out.println("Evening alarm at 6:00 PM");
	}
}
