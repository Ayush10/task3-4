/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookCategory;

import com.admin.dto.BookDto;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ayush
 */
@Getter
@Setter
@ManagedBean
@SessionScoped
public class BookCategoryDataModelJsg implements Serializable {
    private BookDto bookDto;
    private boolean isEdit;
    private List<BookDto> bookDtoList;

    public BookDto getBookDto(){
        return Optional.ofNullable(bookDto).orElse(bookDto = new BookDto());
    }
}

