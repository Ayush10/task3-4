/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookCategory;

import com.admin.dto.AdminDto;
import com.admin.dto.BookDto;
import com.admin.dto.StatusDto;
import com.admin.service.BookService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import lombok.Data;
/**
 *
 * @author Ayush
 */
@Data
@ManagedBean
@SessionScoped
public class BookCategoryBean implements Serializable {
    private BookDto bookDto;
    private AdminDto adminDto;
    private StatusDto statusDto;
    private boolean edit=false;
    private List<BookDto> bookDtoList = new ArrayList<>();
    @EJB
    private BookService bookService;

    @PostConstruct
    public void init(){
        bookDto = new BookDto();
        getAllBooks();

    }
    public void addBook(){

        bookDto.setCreatedDate(new Date());
        boolean response= bookService.addBook(this.bookDto);
       if (response) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Saved", null));

           getAllBooks();
           this.bookDto = new BookDto();
       }
    }

    public void getAllBooks(){
        bookDtoList=bookService.getAllBooks();
    }
    public void deleteBook(BookDto bookDto){
        bookDto.setDeletedDate(new Date());
        boolean success = bookService.deleteBook(bookDto);
        if(success){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted Successfully", null));
            getAllBooks();

        }
    }
    public void updateBook(BookDto bookDto){
        bookDto.setLastUpdatedDate(new Date());
        this.bookDto = bookDto;
        boolean success = bookService.updateBook(this.bookDto);
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated Successfully", null));
            getAllBooks();
            edit = false;
        }
    }
    public void editBook(BookDto bookDtoFromForm){
        edit = true;
        this.bookDto =bookDtoFromForm;
    }
    public void cancelEdit(){
        bookDto = new BookDto();
        edit=false;

    }
}
