package de.petri.homeoffice.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestResource {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String test() {
		return "test";
	}
	
}