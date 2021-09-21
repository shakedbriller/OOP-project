package Model;

import Utils.SnackType;

public class Snack implements Comparable<Snack>{
	private static int idCounter = 1;

	private int id;
	private SnackType type;
	private SnackBar bar;
	private String snackName;
	private boolean isFattening;
	private double price;

	public Snack(SnackType type, String snackName, SnackBar bar, boolean isFattening, double price) {
		super();
		this.id = idCounter++;
		this.type = type;
		this.bar = bar;
		this.snackName = snackName;
		this.isFattening = isFattening;
		this.price = price;
	}

	public Snack(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SnackType getType() {
		return type;
	}

	public void setType(SnackType type) {
		this.type = type;
	}

	public String getSnackName() {
		return snackName;
	}

	public void setSnackName(String snackName) {
		this.snackName = snackName;
	}

	public boolean isFattening() {
		return isFattening;
	}

	public void setFattening(boolean isFattening) {
		this.isFattening = isFattening;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price < 0.0)
			price = 0.0;
		this.price = price;
	}


	public SnackBar getBar() {
		return bar;
	}

	public void setBar(SnackBar bar) {
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", type=" + type + ", snackName=" + snackName + ", isFattening=" + isFattening
				+ ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((snackName == null) ? 0 : snackName.hashCode());
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
		Snack other = (Snack) obj;
		if (id != other.id)
			return false;
		if (snackName == null) {
			if (other.snackName != null)
				return false;
		} else if (!snackName.equals(other.snackName))
			return false;
		return true;
	}

/**
 * compare snack by name
 */
	@Override
	public int compareTo(Snack o) {		
		return getSnackName().compareTo(o.getSnackName());
	}

	
	



}
