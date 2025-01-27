package com.msa.rental.domain.model;

import com.msa.rental.domain.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private long no;
    private String title;
    private BookDesc desc;
    private Classification classification;
    private BookStatus bookStatus;
    private Location location;


    public static Book enterBook(String title,
                                 String author,
                                 String isbn,
                                 String description,
                                 LocalDate publicationDate,
                                 Source source,
                                 Classification classification,
                                 Location location){
        BookDesc bookDesc = BookDesc.createBookDesc(author, isbn, description, publicationDate, source);
        Book book = new Book();
        book.setTitle(title);
        book.setDesc(bookDesc);
        book.setClassification(classification);
        book.setLocation(location);
        book.setBookStatus(BookStatus.ENTERED);
        return book;
    }


    public static Book sample(){
        return enterBook("엔터프라이즈 아키텍처 패턴",
                "마틴 파울러",
                "123123",
                "엔터프라이즈 패턴에 관련된...",
                LocalDate.now(),
                Source.SUPPLY,
                Classification.COMPUTER,
                Location.JEONGJA
        );
    }


    public Book makeAvailable(){
        this.bookStatus = BookStatus.AVAILABLE;
        return this;
    }


    public Book makeUnavailable(){
        this.bookStatus = BookStatus.UNAVAILABLE;
        return this;
    }


}
