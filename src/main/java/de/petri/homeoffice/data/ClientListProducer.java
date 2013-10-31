package de.petri.homeoffice.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import de.petri.homeoffice.model.Client;
import de.petri.homeoffice.services.ClientService;
import de.petri.homeoffice.util.Events.Added;
import de.petri.homeoffice.util.Events.Deleted;
import de.petri.homeoffice.util.Events.Updated;

@RequestScoped
public class ClientListProducer {

    private List<Client> clientList;
    
    @Inject
    private ClientService cs;

    @PostConstruct
    public void init() {
            clientList = cs.getAllClients();
    }

    @Produces
    @Named
    public List<Client> getClients() {
            return clientList;
    }

    public void onAktionAdded(@Observes @Added Client aClient) {
            cs.addClient(aClient);
            init();
    }
    
    public void onAktionDeleted(@Observes @Deleted Client aClient) {
            cs.deleteClient(aClient);
            init();
    }

    public void onAktionUpdated(@Observes @Updated Client aClient) {
            cs.updateClient(aClient);
            init();
    }
	
	
}
