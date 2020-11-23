/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.dao.BookDao;
import com.payrollSystem.entity.common.BookCategory;
import java.util.Optional;
import javax.ejb.Stateless;

/**
 *
 * @author Ayush
 */
@Stateless
public class BookDaoImpl extends StatusableDaoImpl<BookCategory> implements BookDao {

public BookDaoImpl(){
    super(BookCategory.class);
}
    @Override
    public BookCategory getByBookName(String bookName) {

        return (BookCategory) Optional.ofNullable( getEntityManager()
                .createQuery("select  bc from "+getPersistenceClass().getSimpleName()+" bc where bc.name =:NAME")
                .setParameter("NAME",bookName)
                .getSingleResult()).orElse(null);
    }
}
