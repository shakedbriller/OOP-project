package Model;

import java.time.LocalDate;
import java.util.HashSet;

import Exceptions.AnimalsVisitsException;
import Utils.AnimalFood;
import Utils.Gender;
import Utils.Job;

public class Bird extends Animal implements AnimalsVisits{
	private static int idCounter = 1;

	private boolean canFly;

	private boolean photo;
	
	private final int MAX_VISITS = 30; //maximum visits per animal

	public Bird(String name, LocalDate birthDay, AnimalFood food, Gender gender, Section section
			, boolean canFly, boolean photo) {
		super(idCounter++, name, birthDay, food, gender, section);
		this.canFly = canFly;
		this.photo = photo;
	}

	public Bird(int id) {
		super(id);
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	public boolean photo() {
		return photo;
	}

	public void setPhoto(boolean photo) {
		this.photo = photo;
	}


@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (canFly ? 1231 : 1237);
		result = prime * result + (photo ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		if (canFly != other.canFly)
			return false;
		if (photo != other.photo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bird " + super.toString() + " canFly=" + canFly + ", canTakePic=" + photo + "]";
	}


	@Override 
	public void visitcount(Person p) throws AnimalsVisitsException {
		
		if (p== null)
			return;

		if(getVisitCounter() < MAX_VISITS) {
			setVisitCounter(getVisitCounter()+1); //update visit counter
			hasVistedAnimal(p);} 
		else {
			throw new AnimalsVisitsException(); //if counter is higher than maximum visits throw exception
		}}

	@Override
	public boolean hasVistedAnimal(Person p){
		if(getVisitCounter()>= MAX_VISITS&& p instanceof ZooEmployee) { // if person is zoo employee
			if(Zoo.getInstance().getAnimalTreatedByZooEmployee().get(p)==null) //check if employee exist
				Zoo.getInstance().getAnimalTreatedByZooEmployee().put((ZooEmployee) p,new HashSet<Animal>()); //add employee and animal to data structure
			Zoo.getInstance().getAnimalTreatedByZooEmployee().get(p).add(this); //add animal to employee

			return true;

		}
		if(super.getVisitCounter()<MAX_VISITS) { 
			if(p instanceof Visitor) {  //if person is visitor
				if(Zoo.getInstance().getAnimalVisitsByPeople().get(p)==null) //check if visitor exist
					Zoo.getInstance().getAnimalVisitsByPeople().put((Visitor) p,new HashSet<Animal>());	//add visitor and animal to data structure
				Zoo.getInstance().getAnimalVisitsByPeople().get(p).add(this); //add animal to visitors
					return true;
			}	
		}	

		return false;
	}
}
