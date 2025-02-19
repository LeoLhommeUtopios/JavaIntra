package org.example.demokafkastream.streamWitDb;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.stereotype.Component;

@Component
@EnableKafkaStreams
public class KafkaStreamProcessorWithDb {

    private MongoEntityRepository repository;

    public KafkaStreamProcessorWithDb(MongoEntityRepository repository) {
        this.repository = repository;
    }

    @Bean
    public KStream<String,String> process (StreamsBuilder builder){
        KStream<String,String> stream = builder.stream("input-topic", Consumed.with(Serdes.String(),Serdes.String()));

        KStream<String,String> upperCaseStream = stream.mapValues(s -> s.toUpperCase())
                .peek((key,value) -> System.out.println("🔄 Transformed message : "+value));

        upperCaseStream.mapValues(s -> repository.save(new EntityMongo(s)));

        upperCaseStream.to("output-topic");

        System.out.println("🔄 Kafka Stream Processor démarré...");
        return stream;
    }
}
