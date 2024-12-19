package ma.emsi.commande.client;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "message-broker-service", url = "http://localhost:8085/api/messages")
public interface MessageBrokerClient {

    @PostMapping("/send")
    @CircuitBreaker(name = "messageBrokerService", fallbackMethod = "sendMessageFallback")
    @Retry(name = "messageBrokerRetry")
    void sendMessage(@RequestParam String destination, @RequestBody String message);

    default void sendMessageFallback(String destination, String message, Throwable ex) {
        System.out.println("Fallback activé : Impossible d'envoyer le message à " + destination);
        System.out.println("Raison de l'échec : " + ex.getMessage());
    }
}
