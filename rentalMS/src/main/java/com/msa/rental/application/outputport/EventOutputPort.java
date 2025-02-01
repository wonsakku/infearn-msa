package com.msa.rental.application.outputport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.msa.rental.domain.model.event.ItemRented;
import com.msa.rental.domain.model.event.ItemReturned;
import com.msa.rental.domain.model.event.OverdueCleared;

public interface EventOutputPort {
    void occurRentalEvent(ItemRented rentalItemEvent);
    void occurReturnEvent(ItemReturned itemReturnedEvent);
    void occurOverdueClearedEvent(OverdueCleared overdueCleared);
}
