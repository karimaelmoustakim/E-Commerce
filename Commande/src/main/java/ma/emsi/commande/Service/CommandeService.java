package ma.emsi.commande.Service;

import ma.emsi.commande.Repository.CommandeRepo;
import ma.emsi.commande.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepo commandeRepo;

    public List<Commande> getAllCommandes() {
        return commandeRepo.findAll();
    }

    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepo.findById(id);
    }

    public Commande saveCommande(Commande commande) {
        return commandeRepo.save(commande);
    }

    public void deleteCommande(Long id) {
        commandeRepo.deleteById(id);
    }
}
