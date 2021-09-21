package Model;

import java.awt.RenderingHints.Key;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import Exceptions.DuplicatedValuesException;
import Utils.Gender;
import Utils.MyFileLogWriter;

public class Zoo {

	private static Zoo zoo = null;

	private HashMap<Integer, ZooEmployee> employees;
	private HashMap<Integer, Visitor> visitors;
	private HashMap<Integer, Mammal> mammals;
	private HashMap<Integer, Reptile> reptiles;
	private HashMap<Integer, Bird> birds;
	private HashMap<Integer, Section> sections;
	private HashMap<Integer, Snack> snacks;
	private HashMap<Integer, SnackBar> bars;

	private HashMap< Visitor,HashSet<Animal> > animalVisitsByPeople;
	private HashMap< ZooEmployee,HashSet<Animal> > animalTreatedByZooEmployee;

	public static Zoo getInstance()
	{
		if(zoo==null)
			zoo = new Zoo();
		return zoo;
	}

	private Zoo() {

		employees = new HashMap<>();
		visitors = new HashMap<>();
		mammals = new HashMap<>();
		reptiles = new HashMap<>();
		birds = new HashMap<>();
		sections = new HashMap<>();
		snacks = new HashMap<>();
		bars = new HashMap<>();
		animalVisitsByPeople = new HashMap<>();
		animalTreatedByZooEmployee = new HashMap<>();

	}


	public HashMap<Integer, ZooEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(HashMap<Integer, ZooEmployee> employees) {
		this.employees = employees;
	}

	public HashMap<Integer, Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(HashMap<Integer, Visitor> visitors) {
		this.visitors = visitors;
	}

	public HashMap<Integer, Mammal> getMammals() {
		return mammals;
	}

	public void setMammals(HashMap<Integer, Mammal> mammals) {
		this.mammals = mammals;
	}

	public HashMap<Integer, Reptile> getReptiles() {
		return reptiles;
	}

	public void setReptiles(HashMap<Integer, Reptile> reptiles) {
		this.reptiles = reptiles;
	}

	public HashMap<Integer, Bird> getBirds() {
		return birds;
	}

	public void setBirds(HashMap<Integer, Bird> birds) {
		this.birds = birds;
	}

	public HashMap<Integer, Section> getSections() {
		return sections;
	}

	public void setSections(HashMap<Integer, Section> sections) {
		this.sections = sections;
	}

	public HashMap<Integer, Snack> getSnacks() {
		return snacks;
	}

	public void setSnacks(HashMap<Integer, Snack> snacks) {
		this.snacks = snacks;
	}

	public HashMap<Integer, SnackBar> getBars() {
		return bars;
	}

	public void setBars(HashMap<Integer, SnackBar> bars) {
		this.bars = bars;
	}

	public HashMap<Visitor, HashSet<Animal>> getAnimalVisitsByPeople() {
		return animalVisitsByPeople;
	}

	public void setAnimalVisitsByPeople(HashMap<Visitor, HashSet<Animal>> animalVisitsByPeople) {
		this.animalVisitsByPeople = animalVisitsByPeople;
	}

	public HashMap<ZooEmployee, HashSet<Animal>> getAnimalTreatedByZooEmployee() {
		return animalTreatedByZooEmployee;
	}

	public void setEmployeeMap(HashMap<ZooEmployee, HashSet<Animal>> animalTreatedByZooEmployee) {
		this.animalTreatedByZooEmployee = animalTreatedByZooEmployee;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animalTreatedByZooEmployee == null) ? 0 : animalTreatedByZooEmployee.hashCode());
		result = prime * result + ((animalVisitsByPeople == null) ? 0 : animalVisitsByPeople.hashCode());
		result = prime * result + ((bars == null) ? 0 : bars.hashCode());
		result = prime * result + ((birds == null) ? 0 : birds.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((mammals == null) ? 0 : mammals.hashCode());
		result = prime * result + ((reptiles == null) ? 0 : reptiles.hashCode());
		result = prime * result + ((sections == null) ? 0 : sections.hashCode());
		result = prime * result + ((snacks == null) ? 0 : snacks.hashCode());
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
		Zoo other = (Zoo) obj;
		if (animalTreatedByZooEmployee == null) {
			if (other.animalTreatedByZooEmployee != null)
				return false;
		} else if (!animalTreatedByZooEmployee.equals(other.animalTreatedByZooEmployee))
			return false;
		if (animalVisitsByPeople == null) {
			if (other.animalVisitsByPeople != null)
				return false;
		} else if (!animalVisitsByPeople.equals(other.animalVisitsByPeople))
			return false;
		if (bars == null) {
			if (other.bars != null)
				return false;
		} else if (!bars.equals(other.bars))
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
		if (mammals == null) {
			if (other.mammals != null)
				return false;
		} else if (!mammals.equals(other.mammals))
			return false;
		if (reptiles == null) {
			if (other.reptiles != null)
				return false;
		} else if (!reptiles.equals(other.reptiles))
			return false;
		if (sections == null) {
			if (other.sections != null)
				return false;
		} else if (!sections.equals(other.sections))
			return false;
		if (snacks == null) {
			if (other.snacks != null)
				return false;
		} else if (!snacks.equals(other.snacks))
			return false;
		if (visitors == null) {
			if (other.visitors != null)
				return false;
		} else if (!visitors.equals(other.visitors))
			return false;
		return true;
	}




	public boolean addEmployee(ZooEmployee employee) {  
		if(employee == null)
			return false;
		if(!getEmployees().containsValue(employee)) {
			getEmployees().put(employee.getId(), employee);
			employee.getSection().getEmployees().add(employee);
			return true;
		}
		return false;
	}

	public boolean addVisitor(Visitor v) {  // need to throw DuplicatedValues
		if(v == null)
			return false;

		if(!getVisitors().containsValue(v)) {
			getVisitors().put(v.getId(), v);
			return true;

		}
		return false;
	}

	public boolean addMammalById(Mammal m) {
		if(m == null)
			return false;
		
		if(!getMammals().containsValue(m))
		{
			getMammals().put(m.getId(), m);
			m.getSection().getMammals().add(m);
			return true;
		}
		return false;
	}

	public boolean addReptileById(Reptile r) {
		if(r == null)
			return false;

		if(!getReptiles().containsValue(r)) {
			getReptiles().put(r.getId(), r);
			r.getSection().getReptiles().add(r);
			return  true;
		}
		return false;
	}

	public boolean addBirdById(Bird b) {
		if(b == null)
			return false;
		if(!getBirds().containsValue(b)) {
			getBirds().put(b.getId(), b);
			b.getSection().getBirds().add(b);
			return true;
		}
		return false;
	}


	public boolean addSection(Section s) {
		if(s == null)
			return false;

		if(!getSections().containsValue(s)) {
			getSections().put(s.getId(), s);
			return true;}
		return false;
	}


	public boolean addSnack(Snack s) {
		if(s == null)
			return false;

		if(!getSnacks().containsValue(s))
			getSnacks().put(s.getId(), s);
		else
			return false;
		s.getBar().getSnacks().add(s);
		return true;
	}

	public boolean addSnackBar(SnackBar sb, Section s) {
		if(sb == null || s == null)
			return false;

		if(!getBars().containsValue(sb))
			getBars().put(sb.getId(), sb);
		else
			return false;

		s.setBar(sb);
		return true;
	}


	public boolean removeEmployee(ZooEmployee employee) { //remove from hash map
		if(employee == null)
			return false;
		getEmployees().remove(employee.getId());
		employee.getSection().getEmployees().remove(employee);

		return true;
	}

	public boolean removeVisitor(Visitor v) {
		if(v == null)
			return false;
		getVisitors().remove(v.getId());				
		v.getSection().getVisitors().remove(v);
		return true;
	}

	public boolean removeMammal(Mammal m) {
		if(m == null)
			return false;

		getMammals().remove(m.getId());
		m.getSection().getMammals().remove(m);
		return true;
	}

	public boolean removeReptile(Reptile r) {
		if(r == null)
			return false;

		getReptiles().remove(r.getId());
		r.getSection().getReptiles().remove(r);
		return true;
	}

	public boolean removeBird(Bird b) {
		if(b == null)
			return false;

		getBirds().remove(b.getId());
		b.getSection().getBirds().remove(b);
		return true;
	}

	public boolean removeSection(Section oldSection, Section newSection) {
		if(oldSection == null || newSection == null)
			return false;

		newSection.setTodayRevenue(newSection.getTodayRevenue() + oldSection.getTodayRevenue());
		if(oldSection.getBar() != null)
			newSection.getBar().setProfit(newSection.getBar().getProfit() + oldSection.getBar().getProfit());
		for(ZooEmployee ze : oldSection.getEmployees())
			ze.setSection(newSection);
		for(Visitor v : oldSection.getVisitors())
			v.setSection(newSection);
		for(Mammal m : oldSection.getMammals())
			m.setSection(newSection);
		for(Reptile r : oldSection.getReptiles())
			r.setSection(newSection);
		for(Bird b : oldSection.getBirds())
			b.setSection(newSection);
		newSection.getEmployees().addAll(oldSection.getEmployees());
		newSection.getVisitors().addAll(oldSection.getVisitors());
		newSection.getMammals().addAll(oldSection.getMammals());
		newSection.getReptiles().addAll(oldSection.getReptiles());
		newSection.getBirds().addAll(oldSection.getBirds());
		removeSnackBar(oldSection.getBar());
		getSections().remove(oldSection.getId());

		return true;
	}

	public boolean removeSnackBar(SnackBar sb) {
		if(sb == null)
			return false;

		sb.getSection().setBar(null);
		getBars().remove(sb.getId());
		return true;
	}

	public boolean removeSnack(Snack s) {
		if(s == null)
			return false;

		for(SnackBar sb : getBars().values()) {
			sb.getSnacks().remove(s);
		}

		getSnacks().remove(s.getId());
		return true;
	}



	public ZooEmployee getRealEmployee(int id) {
		ZooEmployee e = new ZooEmployee(id);
		if(!getEmployees().containsKey(e.getId()))
			return null;
		return getEmployees().get(e.getId());
	}


	public Visitor getRealVisitor(int id) {
		Visitor v = new Visitor(id);
		if(!getVisitors().containsKey(v.getId()))
			return null;
		return getVisitors().get(v.getId());
	}

	public Mammal getRealMammal(int id) {
		Mammal m = new Mammal(id);
		if(!getMammals().containsKey(m.getId()))
			return null;
		return getMammals().get(m.getId());
	}

	public Reptile getRealReptile(int id) {
		Reptile r = new Reptile(id);
		if(!getReptiles().containsKey(r.getId()))
			return null;
		return getReptiles().get(r.getId());
	}

	public Bird getRealBird(int id) {
		Bird b = new Bird(id);
		if(!getBirds().containsKey(b.getId()))
			return null;
		return getBirds().get(b.getId());
	}

	public Section getRealSection(int id) {
		Section s = new Section(id);
		if(!getSections().containsKey(s.getId()))
			return null;
		return getSections().get(s.getId());
	}

	public SnackBar getRealSnackBar(int id) {
		SnackBar sb = new SnackBar(id);
		if(!getBars().containsKey(sb.getId()))
			return null;
		return getBars().get(sb.getId());
	}

	public Snack getRealSnack(int id) {
		Snack s = new Snack(id);
		if(!getSnacks().containsKey(s.getId()))
			return null;
		return getSnacks().get(s.getId());
	}
	public double checkTotalRevenue() {
		double revenue = 0;
		for(Section s : getSections().values()) { /// Values
			revenue += s.getTodayRevenue();
			revenue += s.getBar().getProfit()*SnackBar.getZooPercentage();
		}
		MyFileLogWriter.println("Zoo Revenue: "+revenue);
		return revenue;
	}

	public boolean newVisitorInZoo(Visitor v, Section s) {
		boolean isValid = true;


		if(v == null || s == null) 
			isValid = false;
		if(!addVisitor(v))
			isValid = false;
		if(isValid && !s.getVisitors().contains(v)) {
			s.getVisitors().add(v);
			v.setSection(s);
			double price = v.checkTicketPrice();
			s.setTodayRevenue(s.getTodayRevenue() + price);
			MyFileLogWriter.println("New "+v+" Paid "+price+" NIS");
			return true;
		}
		MyFileLogWriter.println(v+" didn't enter the zoo");
		return false;
	}



	/**
	 * Query 1.1
	 * return all snacks in a snack bar 
	 * sorted by name 
	 */
	public ArrayList<Snack> findAllSnackByWorker(SnackBar sb) {
		ArrayList<Snack> allSnacks = new ArrayList<Snack>();
		for (Snack s: sb.getSnacks()) {
			if (s instanceof Food){
				if(((Food) s).isSpicy() && !((Food) s).isPlate()) {
					allSnacks.add(s);
				}}
			if(s instanceof Drink) {
				if(((Drink) s).isIceCube() && !((Drink) s).isSprinkel()) {
					allSnacks.add(s);
				}}
		}
		Collections.sort(allSnacks); //compare by name
		return allSnacks;
	}


//1.2
	/**
	 * Query 1.2
	 * find all animals in a section 
	 * sorted by animal type and visits count
	 */
	public ArrayList<Animal> getAllAnimalsBySectionMaxVisits(Section s) {

		ArrayList<Animal> allAnimals =new ArrayList<Animal>();
		HashSet<Bird> birds=s.getBirds();
		HashSet<Reptile> reptiles=s.getReptiles();
		HashSet<Mammal> mammals=s.getMammals();

		List<Bird>  lBirds=new ArrayList<Bird>(birds);
		List<Reptile>  lReptiles=new ArrayList<Reptile>(reptiles);
		List<Mammal>  lMammals=new ArrayList<Mammal>(mammals);
		
		//list of all the animals in zoo
		allAnimals.addAll(lBirds);
		allAnimals.addAll(lReptiles);
		allAnimals.addAll(lMammals);
		allAnimals.sort(new Comparator<Animal>() {
			
			@Override
			public int compare(Animal o1, Animal o2) {					
				//comparing by animal type
				String n1=o1.getClass().getSimpleName();
				String n2=o2.getClass().getSimpleName();

				int compName=n1.compareTo(n2) ;
				if(compName!=0)
					return compName;
				
				// if they are equal then compare them by visits count
				Integer a=o1.getVisitCounter();
				Integer b=o2.getVisitCounter();
				int compCount=a.compareTo(b) ;
				
				// if they are equal then compare them by their natural sprting (birth date)
				if(compCount!=0)
					return compCount;
				else
					return o2.compareTo(o1);
			}			
		});
		return allAnimals;
	}

	/**
	 * Query 1.3
	 * return all animals an employee did not treat
	 */
	
	public ArrayList<Animal> allAnimalsByWorker(ZooEmployee employee) {
		
		//check which animals this employee treated
		ArrayList<Animal> self = new ArrayList<>(); // list of animals employee treated
		HashSet<Animal> allAnimals = new HashSet<>();
		for(Map.Entry<ZooEmployee, HashSet<Animal>> s : animalTreatedByZooEmployee.entrySet()) {
			ZooEmployee eSelf = s.getKey();
			HashSet<Animal> aSelf = s.getValue();
			//add to the self list all animals this employee treated
			if(eSelf.getId()==employee.getId()) {
				for(Animal a:aSelf) {
					if(!self.contains(a))
						self.add(a);
				}
			}
		}
		if (self.isEmpty()) { 		//if didn't treat any animals
			return null;						
		}
		
		//find all animals this employee did not treated
		for(Map.Entry<ZooEmployee, HashSet<Animal>> s : animalTreatedByZooEmployee.entrySet()) {
			ZooEmployee e = s.getKey();
			HashSet<Animal> a = s.getValue();

			if(e.getId()!=employee.getId()) {	
				for(Bird b: birds.values()) {
					if(!a.contains(b)){ //check this employee did not treated it
						if(!b.isCanFly()) // bird can't fly
							allAnimals.add(b);
					}}
						
				for(Reptile r: reptiles.values()) {
					if(!a.contains(r)){ //check this employee did not treated it
						if(r.isDangerous()) //reptile is dengerous
							allAnimals.add(r);
					}}
					
				for(Mammal m: mammals.values()) {	
					if(!a.contains(m)) { //check this employee did not treated it
						if(!m.isMeatEater()) //mammal don't eat meat
							allAnimals.add(m);
					}}
				}
			}
		
		ArrayList<Animal> allAnimalsByWorker = new ArrayList<Animal>(allAnimals); 
        Collections.sort(allAnimalsByWorker);  // natural sorting 
		return allAnimalsByWorker;
	}

	
	/**
	 * Query 1.4
	 * return all reptiles that are not dangerous and do not sleep at winter
	 */
	public ArrayList<Reptile>  reptilesSleepAtSeasson() {
		ArrayList<Reptile> reptilesSleepAtSeasson = new ArrayList<>();
		for(Reptile r: reptiles.values()) {
			if(r.sleepAtWinter() && !r.isDangerous()) {
				reptilesSleepAtSeasson.add(r);
			}
		}

		Collections.sort(reptilesSleepAtSeasson, new Comparator<Reptile>() {

			@Override
			public int compare(Reptile r1,  Reptile r2) {
				//compare reptile's name
				String strName1 = r1.getName(); 
				String strName2 = r2.getName();

				int comp=strName1.compareTo(strName2) ;
				if(comp!=0)return comp;
				//if name is equal compare by genger
				Gender g1=  r1.getGender();
				Gender g2= r2.getGender();
				return  g1.compareTo(g2);
			}	
		});
		return reptilesSleepAtSeasson;
	}



	/**
	 * Query 1.5
	 * return visitor discount sorted by discount amount
	 */
	public TreeMap<Visitor, Double> geAllDiscountAmount() {
		double discount = 0;
		TreeMap<Visitor, Double> allDiscountAmount=new TreeMap<> (new Comparator<Visitor>() {

			@Override
			public int compare(Visitor o1, Visitor o2) { // compare discount amount
				double dis1=o1.getTicket().getValue() - o1.checkTicketPrice();
				double dis2 = o2.getTicket().getValue() -  o2.checkTicketPrice();
				if(dis1 > dis2)
					return 1;
				else if (dis1<dis2)
					return -1;
				return 0;
			}
		});


		for (Visitor v : visitors.values()) {
			double moneyDis=((double)v.getDiscount().getPercentage()/100);
			discount = v.getTicket().getValue() * moneyDis;
			allDiscountAmount.put(v, discount);
		}
		return allDiscountAmount;
	}



	/**
	 * Query 1.6
	 * return section with the biggest difference of visitors and employees
	 */
	public Section getMaxVisitorsVSMaxWorkers() {

		SortedSet<Section> sortedS = new TreeSet<>(new Comparator<Section>( ) {  
			@Override   
			public int compare(Section s1, Section s2) {  //compare difference between visitors and empoyees  
				if(s1.getVisitors().size() -s1.getEmployees().size()> s2.getVisitors().size() -s2.getEmployees().size())
					return 1;
				else if (s1.getVisitors().size() -s1.getEmployees().size() < s2.getVisitors().size() -s2.getEmployees().size())
					return -1;
				else
					return 0;

			}   }); 
		sortedS.addAll(sections.values());
		return sortedS.last(); //the biggest difference
	}
}




