package com.tourian.objects;

/**
 * 
 * @author Charles M Haines II
 * September 15 2022
 * Southern New Hampshire University
 * Dr. Albanie Bolton
 * 
 * Contact object is used to represent a contact and store it's various properties such as first name, last name, and a unique ten character ID.
 * 
 * The ID field is not mutable once the contact object is created. The field is private and does not have a setter. Attempting to set this ID fill fail
 * to compile since the private field is not visible to other classes.
 * 
 */

public class Contact {
	
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String phoneNumber, String address)
	{
		// Throw exception if ID is longer than ten characters or is null
		if (id == null || id.length() > 10)
		{
			throw new IllegalArgumentException("Invalid ID. ID must be 10 characters or less and must not be null.");
		}
		
		// Throw exception if firstName is greater than ten characters or is null
		if (firstName == null || firstName.length() > 10)
		{
			throw new IllegalArgumentException("Invalid first name. First name must be 10 characters or less and must not be null.");
		}
		
		// Throw exception if lastName is greater than ten characters or is null
		if (lastName == null || lastName.length() > 10)
		{
			throw new IllegalArgumentException("Invalid last name. Last name must be 10 characters or less and must not be null.");
		}
		
		// Throw exception if phoneNumber is not exactly ten digits or is null.
		if (phoneNumber == null || phoneNumber.length() != 10)
		{
			throw new IllegalArgumentException("Invalid phone number. Phone number must be exactly 10 digits and must not be null.");
		}
		
		// Throw exception if address exceeds 30 characters or is null.
		if (address == null || address.length() > 30)
		{
			throw new IllegalArgumentException("Invalid address. Address must be 30 characters or less and must not be null.");
		}
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	
	
	

}
