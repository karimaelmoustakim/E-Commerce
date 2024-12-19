package ma.emsi.messagebrokerservice.controller;


import ma.emsi.messagebrokerservice.producteur.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private JmsProducer jmsProducer;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String destination, @RequestBody String message) {
        jmsProducer.sendMessage(destination, message);
        return ResponseEntity.ok("Message envoyé à la destination : " + destination);
    }
}
