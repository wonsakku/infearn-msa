package com.msa.book.application.outputport;

import com.msa.book.framework.web.dto.BookOutPutDTO;

public interface MakeUnAvailableUseCase {
    BookOutPutDTO unavailable(long bookNo);
}
