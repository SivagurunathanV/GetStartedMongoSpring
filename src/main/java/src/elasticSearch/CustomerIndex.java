package src.elasticSearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by sivagurunathanvelayutham on Oct, 2017
 */
@Data
@AllArgsConstructor
@Document(indexName = "customer",type = "customer")
public class CustomerIndex {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return id + "--" + firstName + "--" + lastName;
    }
}
