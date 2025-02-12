package springbootdev.recommendation.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "recommendations")
public class Recommendation {

    @Id
    private String id;
    private String category;
    private String title;
    private String description;
    private double rating;
	
    
    
}
