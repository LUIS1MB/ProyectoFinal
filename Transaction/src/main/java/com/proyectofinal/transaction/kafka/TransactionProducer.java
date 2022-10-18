package com.proyectofinal.transaction.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionProducer {
	private static final String TOPIC = "tTransaction";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		log.info("Producing message {}", message);
		kafkaTemplate.send(TOPIC, message);
	}

}