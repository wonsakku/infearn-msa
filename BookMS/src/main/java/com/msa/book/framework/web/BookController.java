package com.msa.book.framework.web;

import com.msa.book.application.usecase.AddBookUseCase;
import com.msa.book.framework.web.dto.BookInfoDTO;
import com.msa.book.framework.web.dto.BookOutPutDTO;
import com.msa.book.application.usecase.InquiryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {
    private final AddBookUseCase addBookUseCase;
    private final InquiryUseCase inquiryUseCase;


    @PostMapping("/book")
    public ResponseEntity<BookOutPutDTO> createBook(@RequestBody BookInfoDTO bookInfoDTO){
        BookOutPutDTO bookOutPutDTO = addBookUseCase.addBook(bookInfoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookOutPutDTO);
    }

    @GetMapping("/book/{no}")
    public ResponseEntity<BookOutPutDTO> getBookNo(@PathVariable("no") Long no){
        BookOutPutDTO bookInfo = inquiryUseCase.getBookInfo(no);
        return bookInfo != null ?
                ResponseEntity.status(HttpStatus.OK).body(bookInfo) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                ;
    }

}
