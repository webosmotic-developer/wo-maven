package com.wo.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.wo.rest.bean.Contact;

public class ContactService {
	static HashMap<Long, Contact> contactIdMap = getContactIdMap();
	
	public ContactService() {
		super();

		if (contactIdMap == null) {
			contactIdMap = new HashMap<Long, Contact>();
			Date date = new Date();	
			// Creating some object of countries while initializing
			Contact contact1 = new Contact(date.getTime()+1, "Florine", "Atkinson", "9898456321");
			Contact contact2 = new Contact(date.getTime()+2, "Kim", "Hawkins", "9898654123");
			Contact contact3 = new Contact(date.getTime()+3, "Phyllis", "Browning", "9977545621");
			Contact contact4 = new Contact(date.getTime()+4, "Lessie", "Cotton", "9998885621");
			Contact contact5 = new Contact(date.getTime()+5, "Eunice", "Anderson", "9878565421");
			Contact contact6 = new Contact(date.getTime()+6, "Howe", "Chan", "8787564545");
			Contact contact7 = new Contact(date.getTime()+7, "Silvia", "Hamilton", "9968423145");
			Contact contact8 = new Contact(date.getTime()+8, "Christian", "Delaney", "9898665523");
			Contact contact9 = new Contact(date.getTime()+9, "Young", "Vang", "8877464513");
			Contact contact10 = new Contact(date.getTime()+10, "Mcbride", "Bush", "9875621340");
			Contact contact11 = new Contact(date.getTime()+11, "Mccarthy", "Sparks", "9978554411");
			Contact contact12 = new Contact(date.getTime()+12, "Melissa", "Medina", "7878545423");
			Contact contact13 = new Contact(date.getTime()+13, "Kemp", "Dixon", "7896967845");
			Contact contact14 = new Contact(date.getTime()+14, "Eugenia", "Edwards", "8552855246");
			Contact contact15 = new Contact(date.getTime()+15, "Florence", "Alston", "9797464613");
			
			contactIdMap.put(date.getTime()+1, contact1);
			contactIdMap.put(date.getTime()+2, contact2);
			contactIdMap.put(date.getTime()+3, contact3);
			contactIdMap.put(date.getTime()+4, contact4);
			contactIdMap.put(date.getTime()+5, contact5);
			contactIdMap.put(date.getTime()+6, contact6);
			contactIdMap.put(date.getTime()+7, contact7);
			contactIdMap.put(date.getTime()+8, contact8);
			contactIdMap.put(date.getTime()+9, contact9);
			contactIdMap.put(date.getTime()+10, contact10);
			contactIdMap.put(date.getTime()+11, contact11);
			contactIdMap.put(date.getTime()+12, contact12);
			contactIdMap.put(date.getTime()+13, contact13);
			contactIdMap.put(date.getTime()+14, contact14);
			contactIdMap.put(date.getTime()+15, contact15);
			
		}
	}

	public List<Contact> getAllContacts()
	{
		List<Contact> Contacts = new ArrayList<Contact>(contactIdMap.values());
		return Contacts;
	}

	public Contact getContact(long id)
	{
		Contact contact = contactIdMap.get(id);
		return contact;
	}
	
	public Contact addContact(Contact contact)
	{
		Date date = new Date();		
		contact.setId(date.getTime() + (int)(Math.random()*100));
		contactIdMap.put(contact.getId(), contact);
		return contact;
	}
	
	public Contact updateContact(Contact contact)
	{
		if(contact.getId()<=0)
			return null;
		contactIdMap.put(contact.getId(), contact);
		return contact;

	}
	
	public void deleteContact(long id)
	{
		contactIdMap.remove(id);
	}

	public static HashMap<Long, Contact> getContactIdMap() {
		return contactIdMap;
	}
}
