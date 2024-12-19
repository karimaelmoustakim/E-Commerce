package ma.emsi.client;

import ma.emsi.client.Repository.ClientRepository;
import ma.emsi.client.module.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        clientRepository.save(new Client(null, "Ahmed", "ahmed@emsi.ma"));
        clientRepository.save(new Client(null, "Mohamed", "mohamed@emsi.ma"));
        clientRepository.save(new Client(null, "Mahmoud", "mahmoud@emsi.ma"));
    }
}
