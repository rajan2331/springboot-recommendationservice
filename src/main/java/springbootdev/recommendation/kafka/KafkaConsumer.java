package springbootdev.recommendation.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import springbootdev.recommendation.model.Recommendation;
import springbootdev.recommendation.service.RecommendationService;

@Service
public class KafkaConsumer {
    private final RecommendationService recommendationService;

    public KafkaConsumer(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @KafkaListener(topics = "recommendation-topic", groupId = "recommendation-group")
    public void consumeRecommendation(Recommendation recommendation) {
        recommendationService.saveRecommendation(recommendation);
    }
}
