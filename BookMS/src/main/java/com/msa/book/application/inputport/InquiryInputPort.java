package com.msa.book.application.inputport;

import com.msa.book.application.usecase.InquiryUseCase;
import com.msa.book.framework.web.dto.BookOutPutDTO;
import com.msa.book.application.outputport.BookOutPutPort;
import com.msa.book.domain.model.Book;
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
