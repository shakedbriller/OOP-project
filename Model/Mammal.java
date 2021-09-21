package Model;

import java.time.LocalDate;
import java.util.HashSet;

import Exceptions.AnimalsVisitsException;
import Utils.AnimalFood;
import Utils.Gender;
import Utils.Job;

public class Mammal extends Animal implements AnimalsVisits{
	private static int idCounter = 1;
	
	private boolean meatEater;
	
	private boolean photo;
	
	private final int MAX_VISITS = 30; ////maximum visits per animal


	public Mammal(String name, LocalDate birthDay, AnimalFood food, Gender gender, Section section
			, boolean meatEater, boolean photo) {
		super(idCounter++, name, birthDay, food, gender, section);
		this.meatEater = meatEater;
		this.photo = photo;
	}
	
	public Mammal(int id) {
		super(id);
	}

	public boolean isMeatEater() {
		return meatEater;
	}
	
	public boolean isPhoto() {
		return photo;
	}

	public void setMeatEater(boolean meatEater) {
		this.meatEater = meatEater;
	}
	
	public void setPhoto(boolean photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Mammal " +  super.toString() + " Name: " + super.getName() + ", Meat Eater: " + meatEater + ",take a pic" + photo ;
	}

	
	
	@Override 
	public void visitcount(Person p) throws AnimalsVisitsException {
		if(p==null)
			return;
		
		if(getVisitCounter()< MAX_VISITS) {
			setVisitCounter(getVisitCounter()+1);
			hasVistedAnimal(p);}
		else {
			throw new AnimalsVisitsException();
		}
	}

	@Override
	public boolean hasVistedAnimal(Person p){
		if(getVisitCounter()>=MAX_VISITS&& p instanceof ZooEmployee) {	// if person is zoo employee
				if(Zoo.getInstance().getAnimalTreatedByZooEmployee().get(p)==null) //check if employee exist
					Zoo.getInstance().getAnimalTreatedByZooEmployee().put((ZooEmployee) p,new HashSet<Animal>());  //add employee and animal to data structure
				Zoo.getInstance().getAnimalTreatedByZooEmployee().get(p).add(this); //  //add animal to employee		
			return true;
		}
		
		if(super.getVisitCounter()<MAX_VISITS) {
			if(p instanceof Visitor) {  // //if person is visitor
				if(Zoo.getInstance().getAnimalVisitsByPeople().get(p)==null) //check if visitor exist
					Zoo.getInstance().getAnimalVisitsByPeople().put((Visitor) p,new HashSet<Animal>());	//add visitor and animal to data structure
					Zoo.getInstance().getAnimalVisitsByPeople().get(p).add(this); //add to data structure of visitors
				return true;
			}	
		}	
		return false;
	}
}
