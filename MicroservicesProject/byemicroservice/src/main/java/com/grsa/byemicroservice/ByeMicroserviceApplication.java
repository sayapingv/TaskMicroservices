package com.grsa.byemicroservice;

import com.grsa.byemicroservice.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

@SpringBootApplication
@EnableKafka
public class ByeMicroserviceApplication {

	@Autowired
	CounterService counterService;

	@KafkaListener(topics="hello")
	public void msgListener(String msg, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
							@Header(KafkaHeaders.OFFSET) Long offset){
		System.out.println("Я услышал " + msg + " " + offset + " " + partition);
		counterService.increaseCounter("hello");
	}


	public static void main(String[] args) {
		SpringApplication.run(ByeMicroserviceApplication.class, args);
	}
}
