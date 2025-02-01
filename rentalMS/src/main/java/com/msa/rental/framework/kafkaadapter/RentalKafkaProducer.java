package com.msa.rental.framework.kafkaadapter;

import com.msa.rental.application.outputport.EventOutputPort;
import com.msa.rental.domain.model.event.ItemRented;
import com.msa.rental.domain.model.event.ItemReturned;
import com.msa.rental.domain.model.event.OverdueCleared;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalKafkaProducer implements EventOutputPort {

    @Value("${producers.topic1.name}")
    private String TOPIC_RENT;

    @Value("${producers.topic2.name}")
    private String TOPIC_RETURN;

    @Value("${producers.topic3.name}")
    private String TOPIC_CLEAR;

    private final KafkaTemplate<String, ItemRented> kafkaTemplate1;
    private final KafkaTemplate<String, ItemReturned> kafkaTemplate2;
    private final KafkaTemplate<String, OverdueCleared> kafkaTemplate3;


    @Override
    public void occurRentalEvent(ItemRented itemRented) {
        ListenableFuture<SendResult<String, ItemRented>> future = kafkaTemplate1.send(TOPIC_RENT, itemRented);

        future.addCallback(new ListenableFutureCallback<SendResult<String, ItemRented>>() {
            @Override
            public void onSuccess(SendResult<String, ItemRented> result) {
                ItemRented g = result.getProducerRecord().value();
                log.info("Sent message=[{}] with offset=[{}]", g.getItem().getNo(), result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[{}] due to : {}", itemRented.getIdName(), ex.getMessage(), ex);
            }
        });

    }

    @Override
    public void occurReturnEvent(ItemReturned itemReturned) {
        ListenableFuture<SendResult<String, ItemReturned>> future = kafkaTemplate2.send(TOPIC_RETURN, itemReturned);

        future.addCallback(new ListenableFutureCallback<SendResult<String, ItemReturned>>() {
            @Override
            public void onSuccess(SendResult<String, ItemReturned> result) {
                ItemReturned g = result.getProducerRecord().value();
                log.info("Sent message=[{}] with offset=[{}]", g.getItem().getNo(), result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[{}] due to : {}", itemReturned.getItem().getNo(), ex.getMessage(), ex);
            }
        });
    }

    @Override
    public void occurOverdueClearedEvent(OverdueCleared overdueCleared) {
        ListenableFuture<SendResult<String, OverdueCleared>> future = kafkaTemplate3.send(TOPIC_CLEAR, overdueCleared);

        future.addCallback(new ListenableFutureCallback<SendResult<String, OverdueCleared>>() {
            @Override
            public void onSuccess(SendResult<String, OverdueCleared> result) {
                OverdueCleared g = result.getProducerRecord().value();
                log.info("Sent message=[{}] with offset=[{}]", g.getIdName().getId(), result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[{}] due to : {}", overdueCleared.getIdName().getId(), ex.getMessage(), ex);
            }
        });
    }
}
