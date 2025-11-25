package org.nioun.essentials.mog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.nioun.essentials.mog.model.Client;
import org.nioun.essentials.mog.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
    
    @Autowired
    ClientRepository clientRepository;

    
    public ClientRepository getClientRepository() {
        return clientRepository;
    }



    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
   public  List<Client>  findAll(){
        return clientRepository.findAll();
    }

     public Client getById(int id){
        return clientRepository.getById(id);
     }

     public Client saveClient(Client client ){
            return clientRepository.save(client);
     }

     public Client updateClient (int id){
            Client client = clientRepository.getById(id);
            return clientRepository.save(client);
     }

     public void deleteClient (int id){
             Client client = clientRepository.getById(id);
             clientRepository.delete(client);
     }


}
