package de.petri.homeoffice.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import de.petri.homeoffice.model.Contact;
import de.petri.homeoffice.services.ContactService;
import de.petri.homeoffice.util.Events.Added;
import de.petri.homeoffice.util.Events.Deleted;
import de.petri.homeoffice.util.Events.Updated;

@RequestScoped
public class ContactListProducer {

    private List<Contact> contactList;
    
    @Inject
    private ContactService cs;

    @PostConstruct
    public void init() {
            contactList = cs.getAllContacts();
    }

    @Produces
    @Named
    public List<Contact> getContacts() {
            return contactList;
    }

    public void onContactAdded(@Observes @Added Contact aContact) {
            cs.addContact(aContact);
            init();
    }
    
    public void onContactDeleted(@Observes @Deleted Contact aContact) {
            cs.deleteContact(aContact);
            init();
    }

    public void onContactUpdated(@Observes @Updated Contact aContact) {
            cs.updateContact(aContact);
            init();
    }
	
	
}
