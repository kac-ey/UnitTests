package model;

public class Contact {

	private String contactId;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	
	public Contact(String contactId, String firstName, String lastName, String address, String phoneNumber) {
		
		// Validate id length not > 10
		boolean isValidInput = validate(contactId, 10);
		
		// If id meets requirements
		if (isValidInput) {
			this.contactId = contactId;
		}
		
		// Check if requirements are met individually
		isValidInput = isValidInput && setFirstName(firstName);
		isValidInput = isValidInput && setLastName(lastName);
		isValidInput = isValidInput && setAddress(address);
		isValidInput = isValidInput && setPhoneNumber(phoneNumber);
		
		// If requirements not met, throw exception
		if (!isValidInput) {
			throw new IllegalArgumentException("Invalid input");
		}
	}
	
	public boolean setFirstName(String firstName) {
		// Check first name length not > 10
		boolean isValidInput = validate(firstName, 10);
		
		if (isValidInput) {
			this.firstName = firstName;
		}
		return isValidInput;
	}
	
	public boolean setLastName(String lastName) {
		// Check last name length not > 10
		boolean isValidInput = validate(lastName, 10);
				
		if (isValidInput) {
			this.lastName = lastName;
		}
		return isValidInput;
	}
	
	public boolean setAddress(String address) {
		// Check address length not > 20
		boolean isValidInput = validate(address, 20);
						
		if (isValidInput) {
			this.address = address;
		}
		return isValidInput;
	}

	public boolean setPhoneNumber(String phoneNumber) {
		boolean isValidInput = false;
		// Check phone number length = 10
		if (phoneNumber != null) {
			isValidInput = phoneNumber.length() == 10;
		}
								
		if (isValidInput) {
			this.phoneNumber = phoneNumber;
		}
		return isValidInput;
	}
	
	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	private boolean validate(String variable, int length) {
		return (variable != null && variable.length() <= length);
	}
}
