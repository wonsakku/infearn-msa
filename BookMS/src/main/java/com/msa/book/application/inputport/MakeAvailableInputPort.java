package com.msa.book.application.inputport;

import com.msa.book.framework.web.dto.BookOutPutDTO;
import com.msa.book.application.outputport.BookOutPutPort;
import com.msa.book.application.outputport.MakeAvailableUseCase;
import com.msa.book.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MakeAvailableInputPort implements MakeAvailableUseCase {

    private final BookOutPutPort bookOutPutPort;

    @Override
    public BookOutPutDTO available(Long bookNo) {
        Book loadBook = bookOutPutPort.loadBook(bookNo);
        loadBook.makeAvailable();
        return BookOutPutDTO.mapToDTO(loadBook);
    }

}
