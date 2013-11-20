package de.petri.homeoffice.services;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.petri.homeoffice.model.Client;

@Stateless
public class ClientServiceBean implements ClientService {

	@Inject
	private EntityManager em;

	@Resource
	private SessionContext sessionContext;

	
	public List<Client> getAllActiveClients() {

		TypedQuery<Client> query = em.createNamedQuery(Client.findActiveByUser,
				Client.class);
		// query.setParameter("user", getLoggedinUser());
		List<Client> clientList = query.getResultList();
		// transientes bisher gespendet Feld aktualisieren
		// for(Client a: clientList) {
		// Double bisherGespendet = getBisherGespendet(a);
		// a.setBisherGespendet(bisherGespendet);
		// }
		return clientList;
	}
	
	public List<Client> getAllClients() {

		TypedQuery<Client> query = em.createNamedQuery(Client.findByUser,
				Client.class);
		// query.setParameter("user", getLoggedinUser());
		List<Client> clientList = query.getResultList();
		// transientes bisher gespendet Feld aktualisieren
		// for(Client a: clientList) {
		// Double bisherGespendet = getBisherGespendet(a);
		// a.setBisherGespendet(bisherGespendet);
		// }
		return clientList;
	}

	private Object getLoggedinUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public Client addClient(Client client) {
		// Organisator organisator = getLoggedinOrganisator();
		// aktion.setOrganisator(organisator);
		em.persist(client);
		return client;
	}

	public Client getClient(Long clientId) {
		Client managedClient = em.find(Client.class, clientId);
		return managedClient;
	}

	public Client updateClient(Client c) {
		return em.merge(c);
	}

	
	public void deleteClient(Long clientId) {
		Client managedClient = getClient(clientId);
		managedClient.setInactiveFromDate(new Date());
		em.merge(managedClient);
	}

	public void deleteClient(Client c) {
		deleteClient(c.getId());
	}

	
	public void destroyClient(Long clientId) {
		Client managedClient = getClient(clientId);
		em.remove(managedClient);
	}
	
	public void destroyClient(Client c) {
		destroyClient(c.getId());
	}
	
}