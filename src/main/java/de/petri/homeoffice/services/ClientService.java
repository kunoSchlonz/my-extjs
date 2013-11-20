package de.petri.homeoffice.services;

import java.util.List;

import de.petri.homeoffice.model.Client;

public interface ClientService {

	List<Client> getAllClients();

	Client addClient(Client Client);

	void deleteClient(Client Client);

	Client updateClient(Client Client);

	void deleteClient(Long clientId);

	Client getClient(Long clientId);

	void destroyClient(Long clientId);

	List<Client> getAllActiveClients();

}
