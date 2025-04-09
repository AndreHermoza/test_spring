package pe.edu.vallegrande.fast_tradeV2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.fast_tradeV2.model.Client;
import pe.edu.vallegrande.fast_tradeV2.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Crear un nuevo cliente
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Obtener todos los clientes
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Obtener clientes por estado
    public List<Client> getClientsByStatus(String status) {
        return clientRepository.findByStatus(status);
    }

    // Obtener cliente por ID
    public Optional<Client> getClientById(Integer clientId) {
        return clientRepository.findById(clientId);
    }

    // Actualizar un cliente
    public Client updateClient(Integer clientId, Client clientDetails) {
        Optional<Client> existingClient = clientRepository.findById(clientId);
        if (existingClient.isPresent()) {
            Client updatedClient = existingClient.get();
            updatedClient.setCellphone(clientDetails.getCellphone());
            updatedClient.setDni(clientDetails.getDni());
            updatedClient.setNames(clientDetails.getNames());
            updatedClient.setRuc(clientDetails.getRuc());
            updatedClient.setStatus(clientDetails.getStatus());
            return clientRepository.save(updatedClient);
        }
        return null;  // O lanzar una excepción si no existe
    }


    // Eliminar un cliente
    public void deleteClient(Integer clientId) {
        clientRepository.deleteById(clientId);
    }
}
