package com.msa.rental.application.outputport;

import com.msa.rental.framework.web.dto.BookOutPutDTO;

public interface MakeUnAvailableUseCase {
    BookOutPutDTO unavailable(long bookNo);
}
