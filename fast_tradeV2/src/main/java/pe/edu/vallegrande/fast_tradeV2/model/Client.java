package pe.edu.vallegrande.fast_tradeV2.model;

import pe.edu.vallegrande.fast_tradeV2.service.ClientService;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;

    @Column(nullable = false, unique = true)
    private String cellphone;

    private String dni;

    @Column(nullable = false)
    private String names;

    private String ruc;

    @Column(nullable = false)
    private String status = "Activo";

    private String registerDate;
}
