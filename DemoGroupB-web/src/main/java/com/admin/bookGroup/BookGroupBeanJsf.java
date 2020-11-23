/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookGroup;

import com.admin.dto.BookGroupDto;
import com.admin.service.BookGroupService;
import com.admin.util.Utility;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ayush
 */
@Getter
@Setter
@ManagedBean
@RequestScoped
public class BookGroupBeanJsf implements Serializable {

    @ManagedProperty(value = "#{bookGroupDataModelJsf}")
    private BookGroupDataModelJsf bookGroupDataModelJsf;

    @EJB
    private BookGroupService bookGroupService;


    public String save(){
            boolean success = bookGroupService.addBookGroup(bookGroupDataModelJsf.getBookGroupDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Saved", null));
        }
        return navigateToPage();
    }
    public String update(){
        boolean response = bookGroupService.updateBookGroup(bookGroupDataModelJsf.getBookGroupDto());
        if (response) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated Successfully", null));
        }
        return navigateToPage();
    }
    public String delete(){
        boolean success = bookGroupService.deleteBookGroup(bookGroupDataModelJsf.getBookGroupDto());
        if (success){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted Successfully", null));
        }
        return navigateToPage();
    }
    public String saveUpdate(){
        return bookGroupDataModelJsf.getBookGroupDto().getId() == null ? save():update();

    }
    public String initCreate(){
        bookGroupDataModelJsf.setBookGroupDto(new BookGroupDto());
        bookGroupDataModelJsf.setEdit(true);
        return returnToPage();
    }

    public String returnToPage() {
        return "bookGroup.xhtml?faces-redirect=true";
    }
    public String navigateToPage(){
        Utility.removeSessionBeanJSFDataModelObject("bookGroupDataModelJsf");
        bookGroupDataModelJsf = (BookGroupDataModelJsf) Utility.getSessionObject("bookGroupDataModelJsf");
        bookGroupDataModelJsf.setBookGroupDtos(bookGroupService.findAllBookGroups());
        return returnToPage();
    }
}
