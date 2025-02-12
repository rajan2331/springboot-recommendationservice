package springbootdev.recommendation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springbootdev.recommendation.model.Recommendation;
import springbootdev.recommendation.repo.RecommendationRepository;

@Service
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public Recommendation saveRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    public Page<Recommendation> getRecommendationsByCategory(String category, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        return recommendationRepository.findByCategory(category, pageable);
    }

    public List<Recommendation> searchByTitle(String title) {
        return recommendationRepository.searchByTitle(title);
    }

    public Iterable<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }
    
    public Iterable<Recommendation> saveBulkRecommendations(List<Recommendation> recommendations) {
        return recommendationRepository.saveAll(recommendations);
    }
}

