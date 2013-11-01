package de.petri.homeoffice.test;

import de.petri.homeoffice.model.Client;

public class TestDataFactory {

	public static Client createTestClient() {
		Client c = new Client();
		c.setShortName("test client");
		c.setClientType(Client.ClientType.PRIVATPERSON);
		return c;
	}

}