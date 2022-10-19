package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testCreateContact() {
		Contact contact = new Contact("Unique", "First", "Last", "address", "5555555555");
		
		assertTrue(contact != null);
		assertTrue(contact.getContactId().equals("Unique"));
		assertTrue(contact.getFirstName().equals("First"));
		assertTrue(contact.getLastName().equals("Last"));
		assertTrue(contact.getAddress().equals("address"));
		assertTrue(contact.getPhoneNumber().equals("5555555555"));
	}
	
	@Test
	void testIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Unique11111", "First", "Last", "address", "5555555555");
		});
	}
	
	@Test
	void testIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "First", "Last", "address", "5555555555");
		});
	}
	
	@Test
	void testfirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Unique", "First111111", "Last", "address", "5555555555");
		});
	}
	
	@Test
	void testfirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Unique", null, "Last", "address", "5555555555");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Unique", "First", "Last1111111", "address", "5555555555");
		});
	}
	
	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Unique", "First", null, "address", "5555555555");
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Unique", "First", "Last", "address111111111111111111111111", "5555555555");
		});
	}
	
	@Test
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Unique", "First", "Last", null, "5555555555");
		});
	}
	
	@Test
	void testPhoneNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Unique", "First", "Last", "address", "55555555555");
		});
	}
	
	@Test
	void testPhoneNumberTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Unique", "First", "Last", "address", "55555555");
		});
	}
	
	@Test
	void testPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Unique", "First", "Last", "address", null);
		});
	}
}
