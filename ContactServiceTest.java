package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Contact;

class ContactServiceTest {
	
	private static ContactService contactService;

	@BeforeAll
	static void setup() {
		contactService = ContactService.getService();
	}

	@Test
	void testAddContact() {
		Contact contact = new Contact("Unique", "First", "Last", "address", "5555555555");
		
		assertTrue(contactService.addContact(contact));
		
		Contact getContact = contactService.getContact("Unique");
		
		assertTrue(getContact.getContactId().contentEquals(contact.getContactId()));
		assertTrue(getContact.getFirstName().contentEquals(contact.getFirstName()));
		assertTrue(getContact.getLastName().contentEquals(contact.getLastName()));
		assertTrue(getContact.getAddress().contentEquals(contact.getAddress()));
		assertTrue(getContact.getPhoneNumber().contentEquals(contact.getPhoneNumber()));
	}
	
	@Test
	void testAddMultipleContacts() {
		Contact contact1 = new Contact("Band", "Joe", "Walsh", "Cali", "6158675309");
		Contact contact2 = new Contact("Legend", "Joe", "Walsh", "Cali", "6158675309");
		
		assertTrue(contactService.addContact(contact1));
		assertTrue(contactService.addContact(contact2));
	}
	
	@Test
	void testDuplicateFails() {
		Contact contact1 = new Contact("Eagles", "Joe", "Walsh", "Cali", "6158675309");
		Contact contact2 = new Contact("Eagles", "Joe", "Walsh", "Cali", "6158675309");
		
		assertTrue(contactService.addContact(contact1));
		assertFalse(contactService.addContact(contact2));
	}
	
	@Test
	void testGetUpdateContact() {
		Contact contact = new Contact("idInfo", "First", "Last", "address", "5555555555");
		
		assertTrue(contactService.addContact(contact));
		
		Contact update = contactService.getContact(contact.getContactId());
		update.setPhoneNumber("6158675309");
		update = contactService.getContact(update.getContactId());
		
		assertTrue(update.getPhoneNumber().equals("6158675309"));
	}
	
	@Test
	void testGetDeleteContact() {
		Contact contact1 = new Contact("Random", "First", "Last", "address", "5555555555");
		
		assertTrue(contactService.addContact(contact1));
		
		Contact contact2 = contactService.getContact(contact1.getContactId());
		
		assertTrue(contactService.deleteContact(contact2.getContactId()));
		assertTrue(contactService.getContact(contact2.getContactId()) == null);
	}
	
	@Test
	void testInvalidDelete() {
		String invalidId = "invalid";
		
		assertFalse(contactService.deleteContact(invalidId));
	}
}
