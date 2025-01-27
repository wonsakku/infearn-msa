package com.msa.rental.application.usecase;

import com.msa.rental.framework.web.dto.BookInfoDTO;
import com.msa.rental.framework.web.dto.BookOutPutDTO;

public interface AddBookUseCase {
    BookOutPutDTO addBook(BookInfoDTO bookInfoDTO);
}
