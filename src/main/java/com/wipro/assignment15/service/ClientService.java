package com.wipro.assignment15.service;

import java.util.List;
import com.wipro.assignment15.entity.Client;

public interface ClientService {
    List<Client> getAllClients();
    void saveClient(Client client);
    Client getClientById(Long id);
    void deleteClientById(Long id);
}
