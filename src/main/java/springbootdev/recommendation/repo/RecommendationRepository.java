package springbootdev.recommendation.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import springbootdev.recommendation.model.Recommendation;

import java.util.List;

@Repository
public interface RecommendationRepository extends ElasticsearchRepository<Recommendation, String> {
	
	Page<Recommendation> findByCategory(String category, Pageable pageable);
    
	// Fuzzy Serch query 
	@Query("{\"bool\": {\"must\": [{\"match\": {\"title\": \"?0\"}}]}}")
	List<Recommendation> searchByTitle(String title);
	
	
}
