package Model;

import java.time.LocalDate;
import Utils.Gender;
import Utils.Job;

public class ZooEmployee extends Person{
	private static int idCounter = 1;
	
	private Job job;
	
	public ZooEmployee(String firstName, String lastName, LocalDate birthDay, Gender gender, Section section, Job job) {
		super(idCounter++,firstName, lastName, birthDay, gender, section);
		this.job = job;
	}
	
	public ZooEmployee(int id) {
		super(id);
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee Name: "+getFirstName()+" "+getLastName()+", Job: "+job;
	}
	
}
