package com.capgemini.market.persistence.mapper;

import com.capgemini.market.domain.service.Client;
import com.capgemini.market.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "id", target = "id" ),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "celular", target = "cellphone"),
            @Mapping(source = "direccion", target = "adress"),
            @Mapping(source = "correoElectronico", target = "email"),
            @Mapping(source = "compras", target = "purchase"),
    })
    Client toClient(Cliente cliente);
List<Client> toClients(List<Cliente> clientes);
    @InheritInverseConfiguration
    Cliente toCliente(Client client);
}
