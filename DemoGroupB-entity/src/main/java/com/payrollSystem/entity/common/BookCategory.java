/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

/**
 *
 * @author Ayush
 */

import com.payrollSystem.entity.abstracts.AbstractProfile;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BOOK_CATEGORY")
public class BookCategory extends AbstractProfile{
    
}
