package Model;

import java.time.LocalDate;

import Utils.AnimalFood;
import Utils.Gender;

public class Reptile extends Animal{
	private static int idCounter = 1;
	
	private boolean isDangerous;
	
	private boolean sleepAtWinter;
	
	public Reptile(String name, LocalDate birthDay, AnimalFood food, Gender gender, Section section
			, boolean isDangerous, boolean sleepAtWinter) {
		super(idCounter++, name, birthDay, food, gender, section);
		this.isDangerous = isDangerous;
		this.sleepAtWinter = sleepAtWinter;
	}
	
	public Reptile(int id) {
		super(id);
	}

	public boolean isDangerous() {
		return isDangerous;
	}
	
	public boolean sleepAtWinter() {
		return sleepAtWinter;
	}

	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}
	
	public void setSleepAtWinter(boolean sleepAtWinter) {
		this.sleepAtWinter = sleepAtWinter;
	}
	
	@Override
	public String toString() {
		return "Reptile " + super.toString() + " Name: " + super.getName() + ", Dangerous: " + isDangerous + ", sleep at the sesson: " + sleepAtWinter ;
	}

}
