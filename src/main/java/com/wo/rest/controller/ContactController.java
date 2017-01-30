package com.wo.rest.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wo.rest.bean.Contact;
import com.wo.rest.service.ContactService;

@Path("/contacts")
public class ContactController {

	ContactService contactService = new ContactService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> getContacts() {
		List<Contact> listOfContacts = contactService.getAllContacts();
		return listOfContacts;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Contact getContactById(@PathParam("id") long id) {
		return contactService.getContact(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Contact addContact(Contact contact) {
		return contactService.addContact(contact);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Contact updateContact(Contact contact) {
		return contactService.updateContact(contact);

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteContact(@PathParam("id") long id) {
		contactService.deleteContact(id);
	}
}
