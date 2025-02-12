package springbootdev.recommendation.controller;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springbootdev.recommendation.model.Recommendation;
import springbootdev.recommendation.service.RecommendationService;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping
    public Recommendation addRecommendation(@RequestBody Recommendation recommendation) {
        return recommendationService.saveRecommendation(recommendation);
    }

    @GetMapping("/{category}/paginated")
    public Page<Recommendation> getPaginatedRecommendations(
            @PathVariable String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "rating") String sortBy) {
        
        return recommendationService.getRecommendationsByCategory(category, page, size, sortBy);
    }

    @GetMapping("/search")
    public List<Recommendation> searchRecommendations(@RequestParam String title) {
        return recommendationService.searchByTitle(title);
    }

    @GetMapping
    public Iterable<Recommendation> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }
    
    @PostMapping("/bulk")
    public Iterable<Recommendation> addBulkRecommendations(@RequestBody List<Recommendation> recommendations) {
        return recommendationService.saveBulkRecommendations(recommendations);
    }
}

