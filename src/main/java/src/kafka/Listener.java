package src.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import src.elasticSearch.CustomerIndex;
import src.elasticSearch.einterface.CustomerIndexRepo;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sivagurunathanvelayutham on Oct, 2017
 */
public class Listener {

    @Autowired
    public CustomerIndexRepo customerIndexRepo;

    public final CountDownLatch countDownLatch = new CountDownLatch(1);

    @KafkaListener(id = "foo",topics = "topic1", group = "group1")
    public void listen(ConsumerRecord<?,?> record) throws ClassNotFoundException {
        System.out.println("-----------------nothing--------------");
        System.out.println(record);
        Class k = Class.forName(record.toString());
        k.cast(new CustomerIndex());
        System.out.println(k);
        countDownLatch.countDown();
    }
}
