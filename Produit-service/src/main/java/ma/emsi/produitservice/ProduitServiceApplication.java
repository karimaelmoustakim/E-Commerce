package ma.emsi.produitservice;

import ma.emsi.produitservice.Repository.ProduitRepo;
import ma.emsi.produitservice.module.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProduitServiceApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepo produitRepo;

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        produitRepo.save(new Produit(null, "MacBook Pro M1", 12000.0));
        produitRepo.save(new Produit(null, "MacBook Air M1", 11500.0));
        produitRepo.save(new Produit(null, "MacBook Pro M1 Max", 18000.0));
    }
}
