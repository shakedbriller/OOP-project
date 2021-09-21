package Model;
import java.time.LocalDate;

import Utils.AnimalFood;
import Utils.Gender;

public abstract class Animal implements Comparable<Animal> {

	private int id;
	private String name;
	private LocalDate birthDay;
	private AnimalFood food;
	private int visitCounter;
	private Gender gender;
	private Section section;

	public Animal(int id,String name, LocalDate birthDay, AnimalFood food, Gender gender, Section section) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.food = food;
		this.visitCounter = 0;
		this.gender = gender;
		this.section = section;
	}

	public Animal(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public AnimalFood getFood() {
		return food;
	}

	public void setFood(AnimalFood food) {
		this.food = food;
	}

	public int getVisitCounter() {
		return visitCounter;
	}

	public void setVisitCounter(int visitCounter) {
		if(visitCounter < 0)
			visitCounter = 0;
		this.visitCounter = visitCounter;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (birthDay == null) {
			if (other.birthDay != null)
				return false;
		} else if (!birthDay.equals(other.birthDay))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  "[id=" + id + ",\n name=" + name + ", birthDay=" + birthDay + ", food=" + food + ", visitCounter="
				+ visitCounter + ", gender=" + gender + ", section=" + section + "]";
	}

	@Override
	public int compareTo(Animal otherAnimal) {
		return this.getBirthDay().compareTo(otherAnimal.getBirthDay()); //compare animal birth date

	}
	
	




}
