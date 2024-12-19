package ma.emsi.commande.Controller;



import ma.emsi.commande.Service.CommandeService;
import ma.emsi.commande.client.MessageBrokerClient;
import ma.emsi.commande.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private MessageBrokerClient messageBrokerClient;

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id)
                .map(commande -> ResponseEntity.ok(commande))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

//    @PostMapping
//    public Commande createCommande(@RequestBody Commande commande) {
//        return commandeService.saveCommande(commande);
//    }
@PostMapping
public Commande createCommande(@RequestBody Commande commande) {
    Commande savedCommande = commandeService.saveCommande(commande);

    // Envoyer un message à la queue JMS via message-broker-service
    messageBrokerClient.sendMessage("commande-queue", "Nouvelle commande créée : " + savedCommande.getId());

    return savedCommande;
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
