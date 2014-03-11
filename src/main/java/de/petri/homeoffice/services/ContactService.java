package de.petri.homeoffice.services;

import java.util.List;

import de.petri.homeoffice.model.Contact;

public interface ContactService {

	List<Contact> getAllContacts();

	Contact addContact(Contact Contact);

	void deleteContact(Contact Contact);

	Contact updateContact(Contact Contact);

	void deleteContact(Long contactId);

	Contact getContact(Long contactId);

	void destroyContact(Long contactId);

	List<Contact> getAllActiveContacts();

}
