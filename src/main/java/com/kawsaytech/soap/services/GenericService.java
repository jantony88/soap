package com.kawsaytech.soap.services;

import com.kawsaytech.soap.entity.Cliente;
import com.kawsaytech.soap.entity.ClienteDTO;
import com.kawsaytech.soap.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GenericService implements GenericoImplements {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente saveClientes(Cliente cliente) throws Exception {
        Optional<Cliente> existingCliente = clienteRepository.findByIdentificacion(cliente.getIdentificacion());
        if (existingCliente.isPresent()) {
            throw new Exception("Cliente con número de cédula '" + cliente.getIdentificacion() + "' ya existe.");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public List<ClienteDTO> listClientes() {
        return clienteRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        Optional<Cliente> existingCliente = clienteRepository.findByIdentificacion(cliente.getIdentificacion());
        if (existingCliente.isPresent()) {
            // Actualizar los valores del cliente existente
            Cliente updateCliente = existingCliente.get();
            updateCliente.setNombre(cliente.getNombre());
            updateCliente.setApellido(cliente.getApellido());
            updateCliente.setDireccion(cliente.getDireccion());
            updateCliente.setTelefono(cliente.getTelefono());
            updateCliente.setContrasena(cliente.getContrasena());
            updateCliente.setEstado(cliente.isEstado());
            return clienteRepository.save(updateCliente);
        }else {
            throw new RuntimeException("Cliente no encontrado, cedula: " + cliente.getIdentificacion());
        }

    }

    @Override
    public void deleteCliente(String cedula) {
        Optional<Cliente> existingCliente = clienteRepository.findByIdentificacion(cedula);
        if (existingCliente.isPresent()) {
            clienteRepository.deleteByIdentificacion(cedula);
        }else {
            throw new RuntimeException("Cliente no encontrado, cedula: " + cedula);
        }
    }

    @Override
    public Cliente getCliente(String cedula) {
        Optional<Cliente> existingCliente = clienteRepository.findByIdentificacion(cedula);
        log.info("Cliente realiza peticion getCliente, cedula: " +cedula);
        if(existingCliente.isPresent()){
            return existingCliente.get();
        }else {
            Cliente cliente = new Cliente();
            cliente.setMessage("No se encontro datos relacionados con la cedula " + cedula);
            return cliente;
//            throw new RuntimeException("Cliente no encontrado, cedula: " + cedula);
        }
    }

    //mepera DTO
    public ClienteDTO convertToDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getIdentificacion(),
                cliente.getNombre() + " " + cliente.getApellido(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.isEstado(), cliente.getMessage()
        );
    }
    //verificar que ya este registrado
    public Optional<Cliente> findByIdentificacion(String identificacion) {
        return clienteRepository.findByIdentificacion(identificacion);
    }
}
