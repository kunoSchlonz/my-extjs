package de.petri.homeoffice.test;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.petri.homeoffice.model.Contact;
import de.petri.homeoffice.services.ContactService;
import de.petri.homeoffice.services.ContactServiceBean;
import de.petri.homeoffice.util.Resources;

@RunWith(Arquillian.class)
public class ContactServiceTest {
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(Contact.class, ContactService.class,
						ContactServiceBean.class, Resources.class,
						TestDataFactory.class)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}

	@Inject
	ContactService contactService;

	@Test
	public void testAddContact() throws Exception {
		Assert.assertNotNull(contactService);
		Contact c = TestDataFactory.createTestContact();
		Assert.assertNotNull(c);
		Contact x = contactService.addContact(c);
		Assert.assertEquals(x, c);
	}

	@Test
	public void testUpdateContact() throws Exception {
		Assert.assertNotNull(contactService);
		Contact c = TestDataFactory.createTestContact("aaa");
		contactService.addContact(c);
		Long id = c.getId();

		Contact u = contactService.getContact(id);
		Assert.assertNotNull(u);
		u.setShortName("bbb");
		contactService.updateContact(u);

		Contact z = contactService.getContact(id);
		Assert.assertNotNull(z);
		Assert.assertTrue(z.getShortName() == "bbb");
	}

	@Test
	public void testDeleteContact() throws Exception {
		Assert.assertNotNull(contactService);

		Contact c = TestDataFactory.createTestContact();
		contactService.addContact(c);

		List<Contact> clist = contactService.getAllActiveContacts();
		Assert.assertFalse(clist.size() == 0);

		for (Iterator<Contact> iterator = clist.iterator(); iterator.hasNext();) {
			Contact contact = (Contact) iterator.next();
			contactService.deleteContact(contact);
		}
		clist = contactService.getAllActiveContacts();
		Assert.assertTrue(clist.size() == 0);

		c = null;
		c = TestDataFactory.createTestContact("a");
		contactService.addContact(c);
		clist = contactService.getAllActiveContacts();
		Assert.assertFalse(clist.size() == 0);

		for (Iterator<Contact> iterator = clist.iterator(); iterator.hasNext();) {
			Contact contact = (Contact) iterator.next();
			contactService.deleteContact(contact.getId());
		}
		clist = contactService.getAllActiveContacts();
		Assert.assertTrue(clist.size() == 0);

	}

	@Test
	public void testListActiveContacts() throws Exception {
		Assert.assertNotNull(contactService);
		Assert.assertTrue(deleteAllContacts());
		int r = 10;
		for (int i = 0; i < r; i++) {
			contactService.addContact(TestDataFactory
					.createTestContact("aaa_" + i));
		}
		List<Contact> clist = contactService.getAllActiveContacts();
		System.out.println(clist.size());
		Assert.assertTrue(clist.size() > 0);
		Assert.assertTrue(clist.size() == r);

	}

	public boolean deleteAllContacts() {
		boolean ret = true;
		List<Contact> clist = contactService.getAllActiveContacts();
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Vor dem Löschen "
						+ clist.size());
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (Iterator<Contact> iterator = clist.iterator(); iterator.hasNext();) {
			Contact contact = (Contact) iterator.next();
			contactService.deleteContact(contact);
		}
		clist = contactService.getAllActiveContacts();
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Nach dem Löschen"
						+ clist.size());
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if (clist.size() != 0) {
			ret = false;
		}

		return ret;
	}
}