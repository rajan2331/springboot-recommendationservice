package springbootdev.recommendation.repo;


	import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import springbootdev.recommendation.model.Recommendation;

import java.util.List;

@Repository
public interface RecommendationRepository extends ElasticsearchRepository<Recommendation, String> {
    List<Recommendation> findByCategory(String category);
}
