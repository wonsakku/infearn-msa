package com.msa.rental.application.inputport;

import com.msa.rental.application.outputport.BookOutPutPort;
import com.msa.rental.application.outputport.MakeAvailableUseCase;
import com.msa.rental.application.outputport.MakeUnAvailableUseCase;
import com.msa.rental.domain.model.Book;
import com.msa.rental.framework.web.dto.BookOutPutDTO;
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
