package de.petri.homeoffice.test;

import de.petri.homeoffice.model.Client;

public class TestDataFactory {

	public static Client createTestClient() {
		return createTestClient("Test Client");
	}

	public static Client createTestClient(String shortName) {
		Client c = new Client();
		c.setShortName(shortName);
		c.setClientType(Client.ClientType.PRIVATPERSON);
		return c;
	}
}