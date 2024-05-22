package Producer_Consumer.demoPC.kafka;

import Producer_Consumer.demoPC.dto.MyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {


    @KafkaListener(topics = "derevny",groupId = "app.1", containerFactory = "listenerContainerFactory")
    public void listen(MyUser user){
        user.setId(4);
        log.info("[ALFA] Recieved message: "+user);
    }
}
