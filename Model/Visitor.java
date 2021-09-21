package Model;

import java.time.LocalDate;

import Exceptions.MaximumCapcityException;
import Utils.Discount;
import Utils.Gender;
import Utils.MyFileLogWriter;
import Utils.TicketType;

public class Visitor extends Person {
	private static int idCounter = 1;

	private TicketType ticket;
	private Discount discount;

	public Visitor(String firstName, String lastName, LocalDate birthDay, Gender gender, TicketType ticket,
			Discount discount) {
		super(idCounter++, firstName, lastName, birthDay, gender, null);
		this.ticket = ticket;
		this.discount = discount;
	}

	public Visitor(int id) {
		super(id);
	}

	public TicketType getTicket() {
		return ticket;
	}

	public void setTicket(TicketType ticket) {
		this.ticket = ticket;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
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
		Visitor other = (Visitor) obj;
		if (discount != other.discount)
			return false;
		if (ticket != other.ticket)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visitor Name: " + getFirstName() + " " + getLastName() + ", TicketType: " + ticket;
	}

	public boolean moveVisitorToSection(Section newSection) {	
		try {
			//check if after remove the capacity is not less then 50% of the maximum capacity at old section
			if (newSection != null && !getSection().equals(newSection) && getSection().getMaxCapacity() * 0.5 < getSection().getVisitors().size()) {
				getSection().getVisitors().remove(this);
				Section oldSection = getSection();
				setSection(newSection);
				newSection.getVisitors().add(this);
				MyFileLogWriter.println(this + " moved from Section " + oldSection.getSectionName() + " to" + "Section " + newSection);
				return true;
			} else 
				throw new MaximumCapcityException();
		} catch (MaximumCapcityException e) {
			MyFileLogWriter.println(e.getMessage());
			return false;
		}
	}

	public double checkTicketPrice() {
		double perc = 100 - getDiscount().getPercentage();
		double value = ticket.getValue();
		double price = perc * value / 100.0;
		return price;
	}

	public boolean purchaseSnack(Snack s) {
		boolean isValid = true;
		double addMoney = 0;
		if (s == null) 
			isValid = false;
		if (isValid && this.getSection().getBar().getSnacks().contains(s)) {		
			if(s instanceof Food && ((Food) s).isPlate()) { //if food is in plate need to pay 20 NIS more
				addMoney+=20;
			}	
			if(s instanceof Drink && ((Drink) s).isSprinkel()) { //if drink has sprinkle need to pay 5 NIS more
				addMoney+=5;
			}
			this.getSection().getBar().setProfit(this.getSection().getBar().getProfit() + s.getPrice()+addMoney);
			this.getSection().getBar().getSnacks().remove(s);
			MyFileLogWriter.println("Visitor: " + this + " Purchased " + s.getClass().getSimpleName() + ": " + s);
			return true;
		
		} else {
			if(s!=null) 
				MyFileLogWriter.println("Visitor: " + this + " Did Not Purchased any " + s.getClass().getSimpleName().toUpperCase());
			if(s==null)
				MyFileLogWriter.println("Visitor: " + this + " Did Not Purchased Snack" );		
		}
			return false;
	}
}
