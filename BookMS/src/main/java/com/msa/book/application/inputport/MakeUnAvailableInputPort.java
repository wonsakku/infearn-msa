package com.msa.book.application.inputport;

import com.msa.book.framework.web.dto.BookOutPutDTO;
import com.msa.book.application.outputport.BookOutPutPort;
import com.msa.book.application.outputport.MakeUnAvailableUseCase;
import com.msa.book.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MakeUnAvailableInputPort implements MakeUnAvailableUseCase {

    private final BookOutPutPort bookOutPutPort;

    @Override
    public BookOutPutDTO unavailable(long bookNo) {
        Book loadBook = bookOutPutPort.loadBook(bookNo);
        loadBook.makeUnavailable();
        return BookOutPutDTO.mapToDTO(loadBook);
    }
}
