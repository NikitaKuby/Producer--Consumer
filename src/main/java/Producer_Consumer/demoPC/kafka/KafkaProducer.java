package Producer_Consumer.demoPC.kafka;

import Producer_Consumer.demoPC.dto.MyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {
    private final KafkaTemplate<String, MyUser> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, MyUser> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MyUser myUser) {
        try {
            log.info("USER={}", myUser);
            kafkaTemplate.send("goroda", myUser)
                    .whenComplete(
                            (result, ex) -> {
                                if (ex == null) {
                                    log.info(
                                            "message user was sent, offset:{}", myUser.getId(),
                                            result.getRecordMetadata().offset());
                                } else {
                                    log.error("message user was not sent, offset:{}", myUser.getId(), ex);
                                }
                            });

        } catch (Exception ex) {
            log.error("Send error. Value: {}", myUser, ex);
        }
    }
}
