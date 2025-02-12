package springbootdev.recommendation.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import springbootdev.recommendation.model.Recommendation;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, Recommendation> kafkaTemplate;
    private final String recommendationTopic ="recommendation-topic";
    
    public KafkaProducer(KafkaTemplate<String, Recommendation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRecommendation(Recommendation recommendation) {
        kafkaTemplate.send(recommendationTopic, recommendation);
    }
}

