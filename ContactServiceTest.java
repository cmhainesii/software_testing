package com.tourian.tests;

/**
 * 
 * @author Charles M Haines II
 * September 15 2022
 * Southern New Hampshire University
 * Dr. Albanie Bolton
 *  
 *  
 *  Contact service test ensures the functionality of the contact service object.
 *  
 */

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tourian.objects.Contact;
import com.tourian.objects.ContactService;

class ContactServiceTest {
	
	protected ContactService contacts;
	protected Contact testContact1, testContact2, testContact3;

	@BeforeEach
	protected void setUp() {
		testContact1 = new Contact("100", "Ben", "Stein", "5554443321", "500 Mountain Trail");
		testContact2 = new Contact("200", "George", "Wash", "1112223344", "800 Elevator Avenue");
		testContact3 = new Contact("300", "Fred", "Durst", "9876543210", "21 Biskit Street");
		
		contacts = new ContactService();
		
		
		contacts.add(testContact1);
		contacts.add(testContact2);
		contacts.add(testContact3);		
	}
	
	// Test the sanity of the contact service class by adding a new contact with a unique ID number
	// Then we retrieve the contact from the contact service and verify the fields still contain the correct values.
	@Test
	void testCanAddContactWithUniqueId() {
		contacts.add(new Contact("400", "James", "Hetfield", "8889889900", "4820 Aluminum Alley"));
		
		// Attempt to retrieve the contact object we just added from the contactservice list. 
		Contact myContact = contacts.getContactById("400");
		assertTrue(myContact.getFirstName().equals("James"));
		assertTrue(myContact.getLastName().equals("Hetfield"));
		assertTrue(myContact.getPhoneNumber().equals("8889889900"));
		assertTrue(myContact.getAddress().equals("4820 Aluminum Alley"));
	}
	
	// Use one of the test contact objects since it is already on the list and is therefore a duplicate ID.
	@Test
	void testContactWithNonUniqueId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.add(testContact1);
		});
	}
	
	@Test
	void testCanDeleteContactById() {
		// Delete Ben Stein contact object by Id
		contacts.deleteById("100");
		
		// Ensure that it has been deleted from the list
		// Attempting to retrieve the contact by it's ID from the list should fail and throw an exception
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.getContactById("100");
		});	
	}
	
	@Test 
	void testCantDeleteWithInvalidId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.deleteById("900");
		});
	}
	
	@Test
	void canUpdateFirstName() {
		contacts.updateFirstName("200", "Georgette");
		
		// Verify that the first name was updated.
		assertTrue(contacts.getContactById("200").getFirstName().equals("Georgette"));
	}
	
	@Test
	void cantUpdateWithInvalidFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updateFirstName("100", null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updateFirstName("300", "TooLongOfAFirstName");
		});
	}
	
	@Test
	void cantUpdateFirstNameInvalidId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updateFirstName("900", "Valid");
		});
	}
	
	@Test 
	void canUpdateLastName() {
		contacts.updateLastName("300", "Dursting");
		
		// Validate last name was updated
		assertTrue(contacts.getContactById("300").getLastName().equals("Dursting"));
	}
	
	@Test
	void cantUpdateWithInvalidLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updateLastName("300", null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updateLastName("300", "VeryLongLastNameHere");
		});
	}
	
	@Test
	void cantUpdateLastNameWithInvalidId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updateLastName("900", "Last");
		});
	}
	
	@Test
	void canUpdatePhoneNumber() {
		contacts.updatePhoneNumber("200", "5558675309");
		
		assertTrue(contacts.getContactById("200").getPhoneNumber().equals("5558675309"));
	}
	
	@Test
	void cantUpdateWithInvalidPhoneNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updatePhoneNumber("200", null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updatePhoneNumber("200", "1");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updatePhoneNumber("200", "111222333344444444444");
		});
	}
	
	@Test
	void cantUpdatePhoneNumberWithInvalidId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updatePhoneNumber("900", "5558675309");
		});
	}
	
	@Test
	void canUpdateAddress() {
		contacts.updateAddress("100", "800 Mountain Trail");
		
		assertTrue(contacts.getContactById("100").getAddress().equals("800 Mountain Trail"));
	}
	
	@Test
	void cantUpdateWithInvalidAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updateAddress("100", null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updateAddress("100", "SheWillBeComingAroundTheMountainWhenSheComes");
		});
	}
	
	@Test
	void cantUpdateAddressWithInvalidId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contacts.updateAddress("900", "Great Address");
		});
	}
	
	

}
