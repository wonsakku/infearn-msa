package com.msa.rental.application.inputport;

import com.msa.rental.application.outputport.BookOutPutPort;
import com.msa.rental.application.outputport.MakeAvailableUseCase;
import com.msa.rental.domain.model.Book;
import com.msa.rental.framework.web.dto.BookOutPutDTO;
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
