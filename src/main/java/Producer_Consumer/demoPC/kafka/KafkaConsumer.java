package Producer_Consumer.demoPC.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {


    @KafkaListener(topics = "derevny    ")
    public void listen(String message){
        log.info("[ALFA] Recieved message: "+message);
    }
}
