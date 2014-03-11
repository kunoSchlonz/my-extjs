package de.petri.homeoffice.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.petri.homeoffice.model.Contact;
import de.petri.homeoffice.services.ContactService;
import de.petri.homeoffice.util.RestResponse;

@Path("/contact")
public class ContactResource {

	@Inject
	private ContactService cs;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String test() {
		return "test";
	}

	@GET
	@Path("/test2")
	@Produces(MediaType.APPLICATION_JSON)
	public Contact test2() {
		Contact c = new Contact();
		c.setContactType(Contact.ContactType.FIRMA);
		c.setShortName("testshortname");
		return c;
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public RestResponse getAllActiveContacts() {
		List<Contact> contactList = cs.getAllActiveContacts();
		System.out.println("Anz Contacts: " + contactList.size());
		return new RestResponse(true, contactList);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
	public RestResponse addContact(Collection<Contact> cList) {
		ArrayList<Contact> newContactList = new ArrayList<Contact>();
		for (Iterator<Contact> iterator = cList.iterator(); iterator.hasNext();) {
			Contact c = (Contact) iterator.next();
			newContactList.add(cs.addContact(c));
		}
		return new RestResponse(true, newContactList);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public RestResponse updateContactL(Collection<Contact> updatableContactList) {

		ArrayList<Contact> updatedContactList = new ArrayList<Contact>();
		for (Iterator<Contact> iterator = updatableContactList.iterator(); iterator
				.hasNext();) {
			Contact updatableContact = iterator.next();
			long id = updatableContact.getId();

			Contact updatedContact = cs.getContact(id);
			updatedContact.setShortName(updatableContact.getShortName());
			updatedContact = cs.updateContact(updatedContact);
			updatedContactList.add(updatedContact);

		}

		return new RestResponse(true, updatedContactList);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{contactId}")
	public RestResponse deleteContact(
			@PathParam(value = "contactId") Long contactId) {
		cs.deleteContact(contactId);
		return new RestResponse(true);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/destroy/{contactId}")
	public RestResponse destroyContact(
			@PathParam(value = "contactId") Long contactId) {
		cs.destroyContact(contactId);
		return new RestResponse(true);
	}

}
