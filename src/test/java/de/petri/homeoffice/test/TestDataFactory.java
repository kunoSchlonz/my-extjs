package de.petri.homeoffice.test;

import de.petri.homeoffice.model.Contact;

public class TestDataFactory {

	public static Contact createTestContact() {
		return createTestContact("Test Contact");
	}

	public static Contact createTestContact(String shortName) {
		Contact c = new Contact();
		c.setShortName(shortName);
		c.setContactType(Contact.ContactType.PRIVATPERSON);
		return c;
	}
}