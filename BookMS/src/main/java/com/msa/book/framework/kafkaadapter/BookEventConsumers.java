package com.msa.book.framework.kafkaadapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.book.application.outputport.MakeAvailableUseCase;
import com.msa.book.application.outputport.MakeUnAvailableUseCase;
import com.msa.book.domain.model.event.ItemRented;
import com.msa.book.domain.model.event.ItemReturned;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BookEventConsumers {

    private final ObjectMapper objectMapper;
    private final MakeAvailableUseCase makeAvailableUsecase;
    private final MakeUnAvailableUseCase makeUnavailable;


    @KafkaListener(topics = "${consumer.topic1.name}", groupId = "${consumer.groupid.name}")
    public void consumeRental(ConsumerRecord<String, String> record) throws IOException {
        System.out.printf("rental_rent:" + record.value());
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        makeUnavailable.unavailable(itemRented.getItem().getNo());
    }

    @KafkaListener(topics = "${consumer.topic2.name}", groupId = "${consumer.groupid.name}")
    public void consumeReturn(ConsumerRecord<String, String> record) throws IOException {
        System.out.printf("rental_return:" + record.value());
        ItemReturned itemReturned = objectMapper.readValue(record.value(), ItemReturned.class);
        makeAvailableUsecase.available(Long.valueOf(itemReturned.getItem().getNo()));
    }
}
