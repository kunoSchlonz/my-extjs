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

import de.petri.homeoffice.model.Client;
import de.petri.homeoffice.services.ClientService;
import de.petri.homeoffice.services.ClientServiceBean;
import de.petri.homeoffice.util.Resources;

@RunWith(Arquillian.class)
public class ClientServiceTest {
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(Client.class, ClientService.class,
						ClientServiceBean.class, Resources.class,
						TestDataFactory.class)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}

	@Inject
	ClientService clientService;

	@Test
	public void testAddClient() throws Exception {
		Assert.assertNotNull(clientService);
		Client c = TestDataFactory.createTestClient();
		Assert.assertNotNull(c);
		Client x = clientService.addClient(c);
		Assert.assertEquals(x, c);

	}

	@Test
	public void testUpdateClient() throws Exception {
		Assert.assertNotNull(clientService);
		Client c = TestDataFactory.createTestClient("aaa");
		clientService.addClient(c);
		Long id = c.getId();

		Client u = clientService.getClient(id);
		Assert.assertNotNull(u);
		u.setShortName("bbb");
		clientService.updateClient(u);

		Client z = clientService.getClient(id);
		Assert.assertNotNull(z);
		Assert.assertTrue(z.getShortName() == "bbb");

	}

	@Test
	public void testDeleteClient() throws Exception {
		Assert.assertNotNull(clientService);

		Client c = TestDataFactory.createTestClient();
		clientService.addClient(c);

		List<Client> clist = clientService.getAllClients();
		Assert.assertFalse(clist.size() == 0);

		for (Iterator<Client> iterator = clist.iterator(); iterator.hasNext();) {
			Client client = (Client) iterator.next();
			clientService.deleteClient(client);
		}
		clist = clientService.getAllClients();
		Assert.assertTrue(clist.size() == 0);

		c = null;
		c = TestDataFactory.createTestClient("a");
		clientService.addClient(c);
		clist = clientService.getAllClients();
		Assert.assertFalse(clist.size() == 0);

		for (Iterator<Client> iterator = clist.iterator(); iterator.hasNext();) {
			Client client = (Client) iterator.next();
			clientService.deleteClient(client.getId());
		}
		clist = clientService.getAllClients();
		Assert.assertTrue(clist.size() == 0);

	}

	@Test
	public void testListClients() throws Exception {
		Assert.assertNotNull(clientService);
		Assert.assertTrue(deleteAllClients());

		for (int i = 0; i < 1000; i++) {
			clientService.addClient(TestDataFactory
					.createTestClient("aaa_" + i));
		}
		List<Client> clist = clientService.getAllClients();
		Assert.assertTrue(clist.size() > 0);
		Assert.assertTrue(clist.size() == 1000);

	}

	public boolean deleteAllClients() {
		boolean ret = true;
		List<Client> clist = clientService.getAllClients();
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Vor dem Löschen "
						+ clist.size());
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out
				.println("##############>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (Iterator<Client> iterator = clist.iterator(); iterator.hasNext();) {
			Client client = (Client) iterator.next();
			clientService.deleteClient(client);
		}
		clist = clientService.getAllClients();
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