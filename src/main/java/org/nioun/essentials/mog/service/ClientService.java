package org.nioun.essentials.mog.service;

import java.util.List;

import org.nioun.essentials.mog.model.Client;


public interface ClientService {

     List<Client> findAll();

     Client getById(int id);

     Client saveClient(Client client );

     Client updateClient (int id);

     void deleteClient (int id);

}
