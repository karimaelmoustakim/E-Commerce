package ma.emsi.commande.Repository;

import ch.qos.logback.core.net.server.Client;
import ma.emsi.commande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommandeRepo extends JpaRepository<Commande,Long> {
}
