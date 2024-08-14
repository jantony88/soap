package com.kawsaytech.soap.entity.soap;

import com.kawsaytech.soap.entity.ClienteDTO;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "getClienteResponse")
public class GetClienteResponse {
    @XmlElement(name = "cliente")
    private ClienteDTO cliente;

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}
