package com.tourian.tests;

/**
 * 
 * @author Charles M Haines II
 * September 15 2022
 * Southern New Hampshire University
 * Dr. Albanie Bolton
 *  
 *
 * This JUinit test class ensures the functionality of the contact class.
 * There is no test to assert that a contact's id can not be changed because 
 * the contact can only be set once when calling the constructor. The ID field is private and does
 * not have a setter method and is therefore not visible to other classes. The contact class contains no code that modifies the ID.
 */

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.tourian.objects.Contact;

import junit.framework.TestCase;

class ContactTest extends TestCase {
	
	// Contact object to perform testing with
	protected Contact contact;
	

	
	@AfterEach
	protected void tearDown() {
		contact = null;
	}

	// Ensure a contact object can be created and verify properties are set correctly.
	@Test
	void testContactClassSanity() {
		contact = new Contact("8675309", "Jenny", "Tutone", "5558675309", "123 Hollywood Blvd");
		
		assertTrue(contact.getId().equals("8675309"));
		assertTrue(contact.getFirstName().equals("Jenny"));
		assertTrue(contact.getLastName().equals("Tutone"));
		assertTrue(contact.getPhoneNumber().equals("5558675309"));
		assertTrue(contact.getAddress().equals("123 Hollywood Blvd"));
	}
	
	@Test
	void testContactIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("ThisIdIsTooLong", "Frank", "Sinatra", "5551112222", "21.5 Jump Street");
		});
		
	}
	
	@Test 
	void testContactIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Betty", "White", "1234567890", "1601 Pennsylvania Avenue");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("AnId", "AVeryLongFirstNameRightHere", "Short", "5559991212", "18 No Name Street");
		});
	}
	
	@Test
	void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("AnotherID", null, "NotNull", "AlsoNotNul", "12 Important Address Drive");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("IDHere", "First", "ThisNameIsProbabblyTooLongToDealWithForSure", "8009332677", "121 Updog Blvd");
		});
	}
	
	@Test
	void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Reginald", null, "0001112233", "400 Address Avenue");
		});
	}
	
	@Test
	void testPhoneNumberTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("456", "Linus", "Torvalds", "12", "41 Tux Turnpike");
		});
	}
	
	@Test 
	void testPhoneNumberTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("789", "Fred", "Funky", "900800700600300200100", "Perfectly Valid Address");
		});
	}
	
	@Test
	void testPhoneNumberNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("100", "Gentoo", "Linux", null, "Another Great Address");
		});
	}
	
	@Test
	void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("200", "Ferris", "Bueller", "5555551212", "This address is so long that it can't possibly not throw an exception right?");
		});
	}
	
	@Test
	void testAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("300", "Project", "Zomboid", "8009007000", null);
		});
	}
		
}
