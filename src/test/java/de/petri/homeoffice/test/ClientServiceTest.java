package de.petri.homeoffice.test;

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
		/*
		Client c = TestDataFactory.createTestClient();
		Assert.assertNotNull(c);
		Client x = clientService.addClient(c);
		Assert.assertEquals(x, c);
		*/
	}

}