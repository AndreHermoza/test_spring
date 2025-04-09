package pe.edu.vallegrande.fast_tradeV2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.fast_tradeV2.model.Client;
import pe.edu.vallegrande.fast_tradeV2.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientRest {

    @Autowired
    private ClientService clientService;

    // Crear un nuevo cliente
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // Obtener todos los clientes
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // Obtener clientes por estado
    @GetMapping("/status/{status}")
    public List<Client> getClientsByStatus(@PathVariable String status) {
        return clientService.getClientsByStatus(status);
    }

    // Obtener un cliente por ID
    @GetMapping("/{clientId}")
    public Optional<Client> getClientById(@PathVariable Integer clientId) {
        return clientService.getClientById(clientId);
    }

    // Actualizar un cliente
    @PutMapping("/{clientId}")
    public Client updateClient(@PathVariable Integer clientId, @RequestBody Client client) {
        return clientService.updateClient(clientId, client);
    }

    // Eliminar un cliente
    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Integer clientId) {
        clientService.deleteClient(clientId);
    }
}
