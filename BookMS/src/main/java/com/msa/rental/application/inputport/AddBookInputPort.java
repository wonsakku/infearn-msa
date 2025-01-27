package com.msa.rental.application.inputport;

import com.msa.rental.application.outputport.BookOutPutPort;
import com.msa.rental.application.usecase.AddBookUseCase;
import com.msa.rental.domain.model.Book;
import com.msa.rental.domain.model.vo.Classification;
import com.msa.rental.domain.model.vo.Location;
import com.msa.rental.domain.model.vo.Source;
import com.msa.rental.framework.web.dto.BookInfoDTO;
import com.msa.rental.framework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddBookInputPort implements AddBookUseCase {

    private final BookOutPutPort bookOutPutPort;
    @Override
    public BookOutPutDTO addBook(BookInfoDTO bookInfoDTO) {
        Book book = Book.enterBook(bookInfoDTO.getTitle(),
                bookInfoDTO.getAuthor(),
                bookInfoDTO.getIsbn(),
                bookInfoDTO.getDescription(),
                bookInfoDTO.getPublicationDate(),
                Source.valueOf(bookInfoDTO.getSource()),
                Classification.valueOf(bookInfoDTO.getClassification()),
                Location.valueOf(bookInfoDTO.getLocation())
        );

        Book save = bookOutPutPort.save(book);
        return BookOutPutDTO.mapToDTO(save);
    }


}
