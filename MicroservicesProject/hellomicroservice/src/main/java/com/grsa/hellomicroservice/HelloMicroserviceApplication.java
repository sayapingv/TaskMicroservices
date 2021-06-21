package com.grsa.hellomicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class HelloMicroserviceApplication {

//	@Autowired
//	private KafkaConsumer<String, String> consumer;

//	@KafkaListener(topics="msg")
//	public void msgListener(String msg, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
//							@Header(KafkaHeaders.OFFSET) Long offset){
//		System.out.println("Я услышал " + msg + " " + offset + " " + partition);
//	}

	public static void main(String[] args) {
		SpringApplication.run(HelloMicroserviceApplication.class, args);
	}

}
