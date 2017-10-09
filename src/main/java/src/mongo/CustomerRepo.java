package src.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by sivagurunathanvelayutham on Oct, 2017
 */
public interface CustomerRepo extends MongoRepository<Customer,String> {
    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
}
