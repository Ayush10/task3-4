/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.BookGroupDto;
import com.payrollSystem.entity.common.BookGroup;

/**
 *
 * @author Ayush
 */
public class BookGroupMapper extends AbstractCodeMapper {



    public static BookGroupDto convertToDto(BookGroup bookGroup){
        BookGroupDto bookGroupDto = new BookGroupDto();
        convertCommonParameters(bookGroupDto,bookGroup);
        return bookGroupDto;
    }

}

