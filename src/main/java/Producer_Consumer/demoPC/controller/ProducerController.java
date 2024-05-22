package Producer_Consumer.demoPC.controller;

import Producer_Consumer.demoPC.dto.MyUser;
import Producer_Consumer.demoPC.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Math.random;

@Slf4j
@RestController
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    public ProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/kafka/send")
    public String send(@RequestBody String message){
    MyUser msg = new MyUser();
    msg.setMessage(message);
    msg.setId(3);
    kafkaProducer.sendMessage(msg);
    return "Succes";
    }


}
