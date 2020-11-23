/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.serviceImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.AdminDao;
import com.admin.dao.BookDao;
import com.admin.dao.StatusDao;
import com.admin.dto.BookDto;
import com.admin.service.BookService;
import com.payrollSystem.entity.common.BookCategory;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ayush
 */
@Stateless
public class BookServiceImpl implements BookService {
    @EJB
    private AdminDao adminDao;
    @EJB
    private StatusDao statusDao;
    @EJB
    private BookDao bookDao;
    @Override
    public boolean addBook(BookDto bookDto) {
            return bookDao.save(convertToBookCategory(bookDto));
    }

    @Override
    public boolean updateBook(BookDto bookDto) {
        return bookDao.modify(convertToBookCategory(bookDto));
    }

    @Override
    public boolean deleteBook(BookDto bookDto) {
        return bookDao.delete(bookDto.getId());
    }

    @Override
    public BookDto getBook(long id) {
        return convertToBookDto(bookDao.getById(id));
    }

    @Override
    public List<BookDto> getAllBooks() {
        return  bookDao.findAll().stream().map(this::convertToBookDto).collect(Collectors.toList());
    }

    private BookCategory convertToBookCategory(BookDto bookDto){
        BookCategory bookCategory = new BookCategory();
        bookCategory.setId(bookDto.getId());
        bookCategory.setCreatedDate(bookDto.getCreatedDate());
        bookCategory.setDeletedDate(bookDto.getDeletedDate());
        bookCategory.setLastUpdatedDate(bookDto.getLastUpdatedDate());
        bookCategory.setName(bookDto.getName());
        bookCategory.setStatus(statusDao.getByDesc(StatusConstants.CREATE_APPROVE.getName()));
        bookCategory.setDescription(bookDto.getDescription());
        return bookCategory;
    }
    private BookDto convertToBookDto(BookCategory bookCategory){
       BookDto bookDto = new BookDto();
       bookDto.setName(bookCategory.getName());
       bookDto.setDescription(bookCategory.getDescription());
       bookDto.setCreatedDate(bookCategory.getCreatedDate());
       bookDto.setDeletedDate(bookCategory.getDeletedDate());
       bookDto.setDeletedReason(bookCategory.getDeletedReason());
       bookDto.setLastUpdatedDate(bookCategory.getLastUpdatedDate());
       bookDto.setId(bookCategory.getId());
       return bookDto;



    }
}
