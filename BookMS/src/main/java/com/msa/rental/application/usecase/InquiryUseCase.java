package com.msa.rental.application.usecase;

import com.msa.rental.application.outputport.BookOutPutPort;
import com.msa.rental.framework.web.dto.BookOutPutDTO;

public interface InquiryUseCase {
    BookOutPutDTO getBookInfo(long bookNo);
}
