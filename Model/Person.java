package Model;

import java.time.LocalDate;

import Utils.Gender;

public abstract class Person implements Comparable<Person> {
	
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private Gender gender;
	private Section section;
	
	public Person(int id, String firstName, String lastName, LocalDate birthDay, Gender gender, Section section) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.gender = gender;
		this.section = section;
	}
	
	public Person(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
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
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getName();
				//"Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

/**
 * comparing two persons by last name.
 * if they are equal then compare them by first name
 */
	@Override
	public int compareTo(Person otherPerson) {
		int resultName = this.getLastName().compareTo(otherPerson.getLastName());
		if(resultName !=0) //if name is not equal
			return resultName;
		//if objects are equal by last name then compare by first name
		return this.getFirstName().compareTo(otherPerson.getFirstName());
	}
}
