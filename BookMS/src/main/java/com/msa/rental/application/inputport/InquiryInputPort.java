package com.msa.rental.application.inputport;

import com.msa.rental.application.outputport.BookOutPutPort;
import com.msa.rental.application.usecase.InquiryUseCase;
import com.msa.rental.domain.model.Book;
import com.msa.rental.framework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InquiryInputPort implements InquiryUseCase {

    private final BookOutPutPort bookOutPutPort;
    @Override
    public BookOutPutDTO getBookInfo(long bookNo) {
        Book book = bookOutPutPort.loadBook(bookNo);
        return BookOutPutDTO.mapToDTO(book);
    }
}
