/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookGroup;

import com.admin.dto.BookGroupDto;
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
public class BookGroupDataModelJsf implements Serializable {
    private BookGroupDto bookGroupDto;
    private boolean edit;
    private List<BookGroupDto> bookGroupDtos;

    public BookGroupDto getBookGroupDto(){
        return Optional.ofNullable(bookGroupDto).orElse(new BookGroupDto());
    }
}

