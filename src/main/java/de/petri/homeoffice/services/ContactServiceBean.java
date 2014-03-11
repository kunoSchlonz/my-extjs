package de.petri.homeoffice.services;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.petri.homeoffice.model.Contact;

@Stateless
public class ContactServiceBean implements ContactService {

	@Inject
	private EntityManager em;

	@Resource
	private SessionContext sessionContext;

	
	public List<Contact> getAllActiveContacts() {

		TypedQuery<Contact> query = em.createNamedQuery(Contact.findActiveByUser,
				Contact.class);
		// query.setParameter("user", getLoggedinUser());
		List<Contact> contactList = query.getResultList();
		// transientes bisher gespendet Feld aktualisieren
		// for(Contact a: contactList) {
		// Double bisherGespendet = getBisherGespendet(a);
		// a.setBisherGespendet(bisherGespendet);
		// }
		return contactList;
	}
	
	public List<Contact> getAllContacts() {

		TypedQuery<Contact> query = em.createNamedQuery(Contact.findByUser,
				Contact.class);
		// query.setParameter("user", getLoggedinUser());
		List<Contact> contactList = query.getResultList();
		// transientes bisher gespendet Feld aktualisieren
		// for(Contact a: contactList) {
		// Double bisherGespendet = getBisherGespendet(a);
		// a.setBisherGespendet(bisherGespendet);
		// }
		return contactList;
	}

	private Object getLoggedinUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact addContact(Contact contact) {
		// Organisator organisator = getLoggedinOrganisator();
		// aktion.setOrganisator(organisator);
		em.persist(contact);
		return contact;
	}

	public Contact getContact(Long contactId) {
		Contact managedContact = em.find(Contact.class, contactId);
		return managedContact;
	}

	public Contact updateContact(Contact c) {
		return em.merge(c);
	}

	
	public void deleteContact(Long contactId) {
		Contact managedContact = getContact(contactId);
		managedContact.setInactiveFromDate(new Date());
		em.merge(managedContact);
	}

	public void deleteContact(Contact c) {
		deleteContact(c.getId());
	}

	
	public void destroyContact(Long contactId) {
		Contact managedContact = getContact(contactId);
		em.remove(managedContact);
	}
	
	public void destroyContact(Contact c) {
		destroyContact(c.getId());
	}
	
}