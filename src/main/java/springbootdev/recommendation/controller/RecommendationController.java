package springbootdev.recommendation.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/{category}")
    public List<Recommendation> getRecommendations(@PathVariable String category) {
        return recommendationService.getRecommendationsByCategory(category);
    }

    @GetMapping
    public Iterable<Recommendation> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }
}

