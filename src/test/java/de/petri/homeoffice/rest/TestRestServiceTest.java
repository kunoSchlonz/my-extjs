package de.petri.homeoffice.rest;

public class TestRestServiceTest {
	/*
	static final URI BASE_URI = getBaseURI();
    HttpServer server;
    
    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(9998).build();
    }

    @Before
    public void startServer() throws IOException {
        System.out.println("Starting grizzly...");

        Injector injector = Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(UserService.class).to(UserServiceImpl.class);
                bind(UserRepository.class).to(UserRepositoryImpl.class);
            }
        });

        ResourceConfig rc = new PackagesResourceConfig("ngdemo.rest");
        IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory(rc, injector);
        server = GrizzlyServerFactory.createHttpServer(BASE_URI + "rest/", rc, ioc);

        System.out.println(String.format("Jersey app started with WADL available at "
                + "%srest/application.wadl\nTry out %sngdemo\nHit enter to stop it...",
                BASE_URI, BASE_URI));
    }

    @After
    public void stopServer() {
        server.stop();
    }

    @Test
    public void testGetDefaultUser() throws IOException {
        Client client = Client.create(new DefaultClientConfig());
        WebResource service = client.resource(getBaseURI());
        ClientResponse resp = service.path("rest").path("users")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got stuff: " + resp);
        String text = resp.getEntity(String.class);

        assertEquals(200, resp.getStatus());
        assertEquals("{\"firstName\":\"JonFromREST\",\"lastName\":\"DoeFromREST\"}", text);
    }
}
*/    
}
