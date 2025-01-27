package com.msa.rental.application.outputport;

import com.msa.rental.framework.web.dto.BookOutPutDTO;

public interface MakeAvailableUseCase {
    BookOutPutDTO available(Long bookNo);

}
