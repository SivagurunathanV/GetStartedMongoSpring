package src;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import src.mongo.Customer;
import src.mongo.CustomerRepo;

/**
 * Created by sivagurunathanvelayutham on Oct, 2017
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private CustomerRepo repository;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        repository.save(new Customer("Siva","Subbulakshmi"));
        repository.save(new Customer("Velayutham", "Sattanathan"));

        System.out.println("PRINT ALL THE ENTRIES");
        for (Customer custeomer: repository.findAll()) {
        System.out.println(custeomer);
        kafkaTemplate.send("topic1",custeomer.toString());
    }
        System.out.println(repository.findByFirstName("Velayutham"));
        System.out.println(repository.findByLastName("Subbulakshmi"));
    }
}
