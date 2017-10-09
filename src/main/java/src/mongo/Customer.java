package src.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by sivagurunathanvelayutham on Oct, 2017
 */
@Data
@RequiredArgsConstructor
@Document(collection = "customer")
public class Customer {

    @Id
    public String id;

    public String firstName;

    public String lastName;

    public Customer(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id = %s, firstName = %s, lastName =%s]",
                id, firstName,lastName);
    }
}
