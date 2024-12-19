package ma.emsi.factureservice.consume;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class InvoiceConsumer {

    @JmsListener(destination = "commande-queue")
    public void processOrderForInvoice(String orderDetails) {
        System.out.println("Facturation en cours pour : " + orderDetails);
        System.out.println("Message consommé avec succès depuis commande-queue .");
    }

}
