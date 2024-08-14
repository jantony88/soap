package com.kawsaytech.soap.soap.endpoint;

import com.kawsaytech.soap.entity.Cliente;
import com.kawsaytech.soap.entity.soap.GetClienteRequest;
import com.kawsaytech.soap.entity.soap.GetClienteResponse;
import com.kawsaytech.soap.services.GenericoImplements;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Slf4j
public class ClienteEndpoint {
    private static final String NAMESPACE_URI = "http://kawsaytech.com/soap/entity";

    @Autowired
    private GenericoImplements clientService;

    @PayloadRoot(namespace = "", localPart = "getClienteRequest")
    @ResponsePayload
    public GetClienteResponse getCliente(@RequestPayload GetClienteRequest request) {
        GetClienteResponse response = new GetClienteResponse();
        log.info("Recibido solicitud de cliente con cédula: {}", request.getIdentificacion());
        try {
            Cliente cliente = clientService.getCliente(request.getIdentificacion());
            log.info("respueto cliente: {}", cliente);
            if (cliente != null) {
                response.setCliente(clientService.convertToDTO(cliente));
            }
        } catch (Exception e) {
            log.error("Error al obtener cliente: {}", e.getMessage(), e);
            response.setCliente(null);
        }
        return response;
    }
}
