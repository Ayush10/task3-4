/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.service;

import com.admin.dto.BookDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ayush
 */
@Local
public interface BookService {
    boolean addBook(BookDto bookDto);
    boolean updateBook(BookDto bookDto);
    boolean deleteBook(BookDto bookDto);
    BookDto getBook(long id);
     List<BookDto> getAllBooks();
}

