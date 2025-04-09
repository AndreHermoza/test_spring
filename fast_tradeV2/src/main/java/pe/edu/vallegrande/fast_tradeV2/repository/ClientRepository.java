package pe.edu.vallegrande.fast_tradeV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.fast_tradeV2.model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByStatus(String status);
}

