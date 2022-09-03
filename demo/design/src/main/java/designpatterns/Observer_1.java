package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Observer_1 {
	public static void main(String[] args){
		BellAlarm_1 alarm = new BellAlarm_1();
		new MorningAlarm_1(alarm);
		new AfterNoonAlarm_1(alarm);
		new EveningAlarm_1(alarm);

		alarm.doStuff();
	}
}

abstract class Alarm_1{
	protected BellAlarm_1 bellAlarm;
	abstract void ring();
}

class BellAlarm_1{
	protected int val;
	private List<Alarm_1> observers = new ArrayList<>();
	public void add(Alarm_1 alarm){
		this.observers.add(alarm);
	}
	public void execute(){
		observers.stream().forEach(alarm -> alarm.ring());
	}

	// Notifiy all the observers about the change, so that they can consume.
	public void doStuff(){
		// do something here and notify the observers
		this.val = 19;
		execute();
		this.val = 30;
		execute();
	}
}

class MorningAlarm_1 extends Alarm_1{
	MorningAlarm_1(BellAlarm_1 alarm){
		this.bellAlarm = alarm;
		this.bellAlarm.add(this);
	}
	@Override
	void ring() {
		System.out.println("Morning alarm at 5:00 AM");
		System.out.println(this.bellAlarm.val);
	}
}

class AfterNoonAlarm_1 extends Alarm_1{
	AfterNoonAlarm_1(BellAlarm_1 alarm){
		this.bellAlarm = alarm;
		this.bellAlarm.add(this);
	}
	@Override
	void ring() {
		System.out.println("Afternoon alarm at 1:00 PM");
		System.out.println(this.bellAlarm.val);
	}
}

class EveningAlarm_1 extends Alarm_1{
	EveningAlarm_1(BellAlarm_1 alarm){
		this.bellAlarm = alarm;
		this.bellAlarm.add(this);
	}

	@Override
	void ring() {
		System.out.println("Evening alarm at 6:00 PM");
		System.out.println(this.bellAlarm.val);
	}
}