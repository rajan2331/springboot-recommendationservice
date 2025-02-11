package springbootdev.recommendation.service;

import org.springframework.stereotype.Service;

import springbootdev.recommendation.model.Recommendation;
import springbootdev.recommendation.repo.RecommendationRepository;

import java.util.List;

@Service
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public Recommendation saveRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    public List<Recommendation> getRecommendationsByCategory(String category) {
        return recommendationRepository.findByCategory(category);
    }

    public Iterable<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }
}

