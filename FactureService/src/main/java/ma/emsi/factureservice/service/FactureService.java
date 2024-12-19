package ma.emsi.factureservice.service;


import ma.emsi.factureservice.Repo.FactureRepo;
import ma.emsi.factureservice.model.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    @Autowired
    private FactureRepo factureRepo;

    public List<Facture> getAllFactures() {
        return factureRepo.findAll();
    }

    public Optional<Facture> getFactureById(Long id) {
        return factureRepo.findById(id);
    }

    public Facture saveFacture(Facture facture) {
        return factureRepo.save(facture);
    }

    public void deleteFacture(Long id) {
        factureRepo.deleteById(id);
    }
}
