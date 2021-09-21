package Model;

import Utils.SnackType;

public class Drink extends Snack {
	
	private boolean sprinkel;
	private boolean straw;
	private boolean iceCube;
	public Drink(SnackType type, String snackName, SnackBar bar, boolean isFattening, double price, boolean sprinkel,
			boolean straw, boolean iceCube) {
		super(type, snackName, bar, isFattening, price);
		this.sprinkel = sprinkel;
		this.straw = straw;
		this.iceCube = iceCube;
	}
	public boolean isSprinkel() {
		return sprinkel;
	}
	public void setSprinkel(boolean sprinkel) {
		this.sprinkel = sprinkel;
	}
	public boolean isStraw() {
		return straw;
	}
	public void setStraw(boolean straw) {
		this.straw = straw;
	}
	public boolean isIceCube() {
		return iceCube;
	}
	public void setIceCube(boolean iceCube) {
		this.iceCube = iceCube;
	}
	@Override
	public String toString() {
		return "Drink " +  super.toString() + " [sprinkel=" + sprinkel + ", straw=" + straw + ", iceCube=" + iceCube + "]";
	}
	
	
	

}
