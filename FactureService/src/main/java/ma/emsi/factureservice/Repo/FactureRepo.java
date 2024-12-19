package ma.emsi.factureservice.Repo;

import ma.emsi.factureservice.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepo extends JpaRepository<Facture, Long> {
}

