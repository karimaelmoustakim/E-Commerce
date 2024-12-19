package ma.emsi.messagebrokerservice.consumer;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

    @JmsListener(destination = "order-queue")
    public void receiveOrderMessage(String message) {
        System.out.println("Message reçu pour les commandes : " + message);
    }

    @JmsListener(destination = "invoice-queue")
    public void receiveInvoiceMessage(String message) {
        System.out.println("Message reçu pour les factures : " + message);
    }
}
