package com.msa.rental.framework.web.dto;

import com.msa.rental.domain.model.Book;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookOutPutDTO {

    private long bookNo;
    private String bookTitle;
    private String bookStatus;
    public static BookOutPutDTO mapToDTO(Book book) {
        BookOutPutDTO bookOutPutDTO = new BookOutPutDTO();
        bookOutPutDTO.setBookNo(book.getNo());
        bookOutPutDTO.setBookTitle(book.getTitle());
        bookOutPutDTO.setBookStatus(book.getBookStatus().toString());
        return bookOutPutDTO;
    }
}
