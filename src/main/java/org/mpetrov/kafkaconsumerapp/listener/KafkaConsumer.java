package org.mpetrov.kafkaconsumerapp.listener;

import org.mpetrov.kafkaconsumerapp.model.Url;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {
    @KafkaListener(topics = "${cloudkarafka.topic}")
    public void consumeJson(Url url) {
        System.out.println("Consumed Json message = " + url);
        url.getHttpHeaders().keySet().forEach(System.out::println);
        url.getHttpHeaders().values().forEach(System.out::println);
        url.getQueryVariables().keySet().forEach(System.out::println);
        url.getQueryVariables().values().forEach(System.out::println);
        url.getPathVariables().keySet().forEach(System.out::println);
        url.getPathVariables().values().forEach(System.out::println);


    }
}
