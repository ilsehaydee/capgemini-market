package com.capgemini.market.web.controller;

import com.capgemini.market.domain.service.Client;
import com.capgemini.market.domain.service.ClientService;
import com.capgemini.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") String id) {
        return clientService.getClient(id);
    }

    @PostMapping("/save")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping("/update/{id}/{name}")
    public boolean delete(@PathVariable("id") String id) {
        return clientService.delete(id);
    }

    @PutMapping("/update/{id}/{name}/{lastName}")
    public Optional<Client> updateNameClient(@PathVariable("name") String name, @PathVariable("lastName") String lastName, @PathVariable("id") String id){
        return clientService.updateNameClient(name, id);
    }

}
