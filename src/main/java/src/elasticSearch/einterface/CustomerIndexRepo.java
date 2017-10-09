package src.elasticSearch.einterface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import src.elasticSearch.CustomerIndex;

/**
 * Created by sivagurunathanvelayutham on Oct, 2017
 */
public interface CustomerIndexRepo extends ElasticsearchRepository<CustomerIndex, String>{

    Page<CustomerIndex> findByFirstName(String firstName, Pageable pageable);

    Page<CustomerIndex> findByLastName(String lastName, Pageable pageable);
}
