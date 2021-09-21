package Utils;

public enum TicketType {
	Child(20), Adult(40), Old(30), Student(30), Soldiar(25), EmployeeRelative(10);
	private final int value;
	
	private TicketType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
	
	
}
