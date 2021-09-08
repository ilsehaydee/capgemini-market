package com.capgemini.market.domain.repository;

import com.capgemini.market.domain.service.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> getClient(String id);
    Optional<List<Client>>  getClientByNameAndLastName(String name, String lastName);
    Client save(Client client);
    void delete(String id);

    Optional<Client> updateNameCliente(String name, String id);

}

