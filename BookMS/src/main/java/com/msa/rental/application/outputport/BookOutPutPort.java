package com.msa.rental.application.outputport;

import com.msa.rental.domain.model.Book;

public interface BookOutPutPort {
    Book loadBook(long bookNo);

    Book save(Book book);
}
