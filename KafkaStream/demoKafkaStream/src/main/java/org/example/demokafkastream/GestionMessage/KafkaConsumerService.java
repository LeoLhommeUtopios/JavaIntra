package org.example.demokafkastream.GestionMessage;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "output-topic",groupId = "Kafka-consumer-group")
    public void consume (ConsumerRecord<String,String> record){
        System.out.println("✅ Message Recu : "+record.value());
    }
}
