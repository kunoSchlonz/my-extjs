package de.petri.homeoffice.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.petri.homeoffice.model.Client;
import de.petri.homeoffice.services.ClientService;

@Path("/client")
public class ClientResource {

	@Inject
	private ClientService cs;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String test() {
		return "test";
	}

	@GET
	@Path("/test2")
	@Produces(MediaType.APPLICATION_JSON)
	public Client test2() {
		Client c = new Client();
		c.setClientType(Client.ClientType.FIRMA);
		c.setShortName("testshortname");
		return c;
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getAllClients() {
		List<Client> clientList = cs.getAllClients();
		System.out.println("Anz Clients: " + clientList.size());
		return clientList;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Client addClient(Client client) {
		return cs.addClient(client);
	}

	@PUT
	@Path("/update/{clientId}")
	public Client updateClient(@PathParam(value = "clientId") Long clientId,
			Client newClient) {
		Client c = cs.getClient(clientId);
		c.setShortName(newClient.getShortName());
		newClient = cs.updateClient(c);
		return newClient;
	}

	@DELETE
	@Path("/delete/{clientId}")
	public Client deleteClient(@PathParam(value = "clientId") Long clientId) {
		cs.deleteClient(clientId);
		return null;
	}

}
