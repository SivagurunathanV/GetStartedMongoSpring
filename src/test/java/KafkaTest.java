import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import src.kafka.Listener;

/**
 * Created by sivagurunathanvelayutham on Oct, 2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = src.Application.class)
public class KafkaTest {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    private Listener listener;

    @Test
    public void contextLoad(){
        ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send("topic1","welcome to kafka");
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("failure");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("success");
            }
        });

        System.out.println(Thread.currentThread().getId());

    }
}
