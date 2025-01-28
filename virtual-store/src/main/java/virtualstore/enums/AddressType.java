package virtualstore.enums;

public enum AddressType {
	DELIVERY("entrega"),
	CHARGE("cobrança");
	
	private String description;
	
	private AddressType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}	
}
