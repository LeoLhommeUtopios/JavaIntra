package org.example.demokafkastream.GestionMessage;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage (String key,String message){
        kafkaTemplate.send("input-topic",key,message);
        System.out.println("📤 Message envoyé : "+message);
    }
}
