package com.kawsaytech.soap.services;



import com.kawsaytech.soap.entity.Cliente;
import com.kawsaytech.soap.entity.ClienteDTO;

import java.util.List;

public interface GenericoImplements {

    Cliente saveClientes(Cliente cliente) throws Exception;

    List<ClienteDTO> listClientes();

    Cliente updateCliente(Cliente response);

    void deleteCliente(String cedula);

    Cliente getCliente(String cedula);

    ClienteDTO convertToDTO(Cliente cliente);
}
