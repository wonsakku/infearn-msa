package com.msa.book.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BookDesc {

    private String description;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private Source source;

    public static BookDesc createBookDesc(String author,
                                          String isbn,
                                          String description,
                                          LocalDate publicationDate,
                                          Source source
                                          ){
        return BookDesc.builder()
                .description(description)
                .author(author)
                .isbn(isbn)
                .publicationDate(publicationDate)
                .source(source)
                .build();
    }

    public static BookDesc sample(){
        return createBookDesc("마틴파울러",
                "123123",
                "엔터프라이즈 아키텍처 패턴",
                LocalDate.now(),
                Source.SUPPLY
        );
    }


}
