package com.tourian.objects;

/**
 * 
 * @author Charles M Haines II
 * September 15 2022
 * Southern New Hampshire University
 * Dr. Albanie Bolton
 * 
 * Contact service class contains various methods and fields to store a collection of contact objects.
 *  
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactService {
	
	private List<Contact> contacts;
	
	public ContactService()
	{
		contacts = new ArrayList<>();
	}
	
	// Add contact to list
	public void add(Contact newContact) {
		// Check if contact ID already exists and throw an exception if ID is already found in the contacts list.
		for (Contact currentContact : contacts)
		{
			if (currentContact.getId() == newContact.getId())
			{
				throw new IllegalArgumentException("Contact ID already exists in contacts list. New contacts require a unique ID.");
			}
		}
		
		// Add contact to list
		contacts.add(newContact);
	}
	
	// Delete a contact from the list
	public void deleteById(String id)
	{
		// Loop through contact list until provided ID is found.
		Iterator<Contact> contactIterator = contacts.iterator();
		while (contactIterator.hasNext())
		{
			Contact currentContact = contactIterator.next();
			
			// If currentContact matches supplied ID, remove it from the list.
			if (currentContact.getId() == id)
			{
				contactIterator.remove();
				return; // Stop looping since the contact has been removed.
			}
		}
		
		// If execution reaches here, the contact was not found. Throw a new exception.
		throw new IllegalArgumentException("Delete contact failed. No contact matching the supplied ID was found.");
	}
	
	// Update a contact's first name
	public void updateFirstName(String id, String firstName)
	{
		// If supplied first name is greater than ten characters or is null, throw an exception.
		if (firstName == null || firstName.length() > 10)
		{
			throw new IllegalArgumentException("Invalid first name. First name must be 10 characters or less and must not be null.");
		}
		
		// Loop through contacts until the contact with the supplied ID is found
		for (Contact currentContact : contacts)
		{
			if (currentContact.getId() == id)
			{
				// Update the first name field
				currentContact.setFirstName(firstName);
				return;
			}
		}
		
		// Contact was not found, throw exception.
		throw new IllegalArgumentException("Invalid ID. Contact not found.");
	}
	
	// Update a contact's last name
	public void updateLastName(String id, String lastName)
	{
		// If supplied last name is greater than ten characters or is null, throw an exception.
		if (lastName == null || lastName.length() > 10)
		{
			throw new IllegalArgumentException("Invalid last name. Last name must be 10 characters or less and must not be empty.");
		}
		
		// Loop through contacts until the contact with the supplied ID is found
		for (Contact currentContact : contacts)
		{
			if (currentContact.getId() == id)
			{
				// Update the last name field
				currentContact.setLastName(lastName);
				return;
			}
		}
		
		// Contact was not found, throw exception.
		throw new IllegalArgumentException("Invalid ID. Contact not found.");
	}
	
	// Update a contact's phone number
	public void updatePhoneNumber(String id, String phoneNumber)
	{
		// If supplied phone number is not exactly ten digits or is null, throw an exception.
		if (phoneNumber == null || phoneNumber.length() != 10)
		{
			throw new IllegalArgumentException("Invalid phone number. Phone number must be exactly 10 digits and must not be empty.");
		}
		
		// Loop through contacts until the contact with the supplied ID is found
		for (Contact currentContact : contacts)
		{
			if (currentContact.getId() == id)
			{
				// Update the phone number field
				currentContact.setPhoneNumber(phoneNumber);
				return;
			}
		}
		
		// Contact was not found, throw exception.
		throw new IllegalArgumentException("Invalid ID. Contact not found.");
	}
	
	// Update a contact's address
	public void updateAddress(String id, String address)
	{
		// If supplied address name is greater than thirty characters or is null, throw an exception.
		if (address == null || address.length() > 30)
		{
			throw new IllegalArgumentException("Invalid address. Address must be 30 characters or less and must not be null.");
		}
		
		// Loop through contacts until the contact with the supplied ID is found
		for (Contact currentContact : contacts)
		{
			if (currentContact.getId() == id)
			{
				// Update the address field
				currentContact.setAddress(address);
				return;
			}
		}
		
		// Contact was not found, throw exception.
		throw new IllegalArgumentException("Invalid ID. Contact not found.");
	}
	
	// Retrieve a contact object from the list by ID. 
	public Contact getContactById(String id) {
		for (Contact currentContact : contacts) {
			if (currentContact.getId().equals(id)) {
				return currentContact;
			}
		}
		throw new IllegalArgumentException("Invalid ID. Contact not found.");
	}
	

}
