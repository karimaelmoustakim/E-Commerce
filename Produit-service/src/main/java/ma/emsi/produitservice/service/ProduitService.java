package ma.emsi.produitservice.service;

import ma.emsi.produitservice.Repository.ProduitRepo;
import ma.emsi.produitservice.module.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepo produitRepo;

    public List<Produit> getAllProduits() {
        return produitRepo.findAll();
    }

    public Optional<Produit> getProduitById(Long id) {
        return produitRepo.findById(id);
    }

    public Produit saveProduit(Produit produit) {
        return produitRepo.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepo.deleteById(id);
    }
}

