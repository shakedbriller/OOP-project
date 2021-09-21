package Model;

import java.util.ArrayList;
import java.util.HashSet;

import Utils.MyFileLogWriter;

public class Section {
	private static int idCounter = 1;
	
	private int id;
	private String sectionName;
	private SnackBar bar;
	private final int maxCapacity;
	private double todayRevenue;
	
	private HashSet<ZooEmployee> employees;
	private HashSet<Visitor> visitors;
	private HashSet<Mammal> mammals;
	private HashSet<Reptile> reptiles;
	private HashSet<Bird> birds;
	
	public Section(String sectionName, int maxCapacity) {
		super();
		this.id = idCounter++;
		this.sectionName = sectionName;
		this.maxCapacity = maxCapacity;
		todayRevenue = 0;
		employees = new HashSet<>();
		visitors = new HashSet<>();
		mammals = new HashSet<>();
		reptiles = new HashSet<>();
		birds = new HashSet<>();
	}
	
	public Section(int id) {
		super();
		this.id = id;
		this.maxCapacity = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public SnackBar getBar() {
		return bar;
	}

	public void setBar(SnackBar bar) {
		this.bar = bar;
	}

	public double getTodayRevenue() {
		return todayRevenue;
	}

	public void setTodayRevenue(double todayRevenue) {
		if(todayRevenue < 0.0)
			todayRevenue = 0.0;
		this.todayRevenue = todayRevenue;
	}

	public HashSet<ZooEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(HashSet<ZooEmployee> employees) {
		this.employees = employees;
	}

	public HashSet<Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(HashSet<Visitor> visitors) {
		this.visitors = visitors;
	}

	public HashSet<Mammal> getMammals() {
		return mammals;
	}

	public void setMammals(HashSet<Mammal> mammals) {
		this.mammals = mammals;
	}

	public HashSet<Reptile> getReptiles() {
		return reptiles;
	}

	public void setReptiles(HashSet<Reptile> reptiles) {
		this.reptiles = reptiles;
	}

	public HashSet<Bird> getBirds() {
		return birds;
	}

	public void setBirds(HashSet<Bird> birds) {
		this.birds = birds;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", sectionName=" + sectionName + ", maxCapacity=" + maxCapacity + ", todayRevenue="
				+ todayRevenue + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bar == null) ? 0 : bar.hashCode());
		result = prime * result + ((birds == null) ? 0 : birds.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + id;
		result = prime * result + ((mammals == null) ? 0 : mammals.hashCode());
		result = prime * result + maxCapacity;
		result = prime * result + ((reptiles == null) ? 0 : reptiles.hashCode());
		result = prime * result + ((sectionName == null) ? 0 : sectionName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(todayRevenue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((visitors == null) ? 0 : visitors.hashCode());
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
		Section other = (Section) obj;
		if (bar == null) {
			if (other.bar != null)
				return false;
		} else if (!bar.equals(other.bar))
			return false;
		if (birds == null) {
			if (other.birds != null)
				return false;
		} else if (!birds.equals(other.birds))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (id != other.id)
			return false;
		if (mammals == null) {
			if (other.mammals != null)
				return false;
		} else if (!mammals.equals(other.mammals))
			return false;
		if (maxCapacity != other.maxCapacity)
			return false;
		if (reptiles == null) {
			if (other.reptiles != null)
				return false;
		} else if (!reptiles.equals(other.reptiles))
			return false;
		if (sectionName == null) {
			if (other.sectionName != null)
				return false;
		} else if (!sectionName.equals(other.sectionName))
			return false;
		if (Double.doubleToLongBits(todayRevenue) != Double.doubleToLongBits(other.todayRevenue))
			return false;
		if (visitors == null) {
			if (other.visitors != null)
				return false;
		} else if (!visitors.equals(other.visitors))
			return false;
		return true;
	}
	
	public void getSectionDetails() {
		int animalNum = mammals.size()+reptiles.size()+birds.size();
		MyFileLogWriter.println("Section "+getSectionName()+" ,Number Of Employees: "+
	getEmployees().size() +" ,Number Of Visitors: "+getVisitors().size()+ " ,Number Of"
			+ " Animals: "+animalNum+" ,Profit Today: "+getTodayRevenue());
	}
	
}
