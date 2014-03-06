package de.petri.homeoffice.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import de.petri.homeoffice.util.RestResponse;

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
	public RestResponse getAllActiveClients() {
		List<Client> clientList = cs.getAllActiveClients();
		System.out.println("Anz Clients: " + clientList.size());
		return new RestResponse(true, clientList);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
	public RestResponse addClient(Collection<Client> cList) {
		ArrayList<Client> newClientList = new ArrayList<Client>();
		for (Iterator<Client> iterator = cList.iterator(); iterator.hasNext();) {
			Client c = (Client) iterator.next();
			newClientList.add(cs.addClient(c));
		}
		return new RestResponse(true, newClientList);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public RestResponse updateClientL(Collection<Client> updatableClientList) {

		ArrayList<Client> updatedClientList = new ArrayList<Client>();
		for (Iterator<Client> iterator = updatableClientList.iterator(); iterator
				.hasNext();) {
			Client updatableClient = iterator.next();
			long id = updatableClient.getId();

			Client updatedClient = cs.getClient(id);
			updatedClient.setShortName(updatableClient.getShortName());
			updatedClient = cs.updateClient(updatedClient);
			updatedClientList.add(updatedClient);

		}

		return new RestResponse(true, updatedClientList);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{clientId}")
	public RestResponse deleteClient(
			@PathParam(value = "clientId") Long clientId) {
		cs.deleteClient(clientId);
		return new RestResponse(true);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/destroy/{clientId}")
	public RestResponse destroyClient(
			@PathParam(value = "clientId") Long clientId) {
		cs.destroyClient(clientId);
		return new RestResponse(true);
	}

}
