package Model;

import Utils.SnackType;

public class Food extends Snack {
	
	private boolean plate;
	private boolean spicy;
	private boolean gluten;
	
	public Food(SnackType type, String snackName, SnackBar bar, boolean isFattening, double price, boolean plate,
			boolean spicy, boolean gluten) {
		super(type, snackName, bar, isFattening, price);
		this.plate = plate;
		this.spicy = spicy;
		this.gluten = gluten;
	}
	public boolean isPlate() {
		return plate;
	}
	public void setPlate(boolean plate) {
		this.plate = plate;
	}
	public boolean isSpicy() {
		return spicy;
	}
	public void setSpicy(boolean spicy) {
		this.spicy = spicy;
	}
	public boolean isGluten() {
		return gluten;
	}
	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}
	@Override
	public String toString() {
		return "Food " + super.toString() + " [plate=" + plate + ", spaciy=" + spicy + "]";
	}
	
	
	

}
