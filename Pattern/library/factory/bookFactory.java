/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.factory;

import Pattern.library.book.book;
import Pattern.library.book.english;
import Pattern.library.book.journal;
import Pattern.library.book.magzine;
import Pattern.library.interfaces.books;
import Pattern.library.interfaces.librarians;
import Pattern.library.interfaces.readers;
import Pattern.library.interfaces.transactions;

/**
 *
 * @author Admin
 */
public class bookFactory extends AbstractFactory{

    @Override
    public books getBook(Types type) {
        books b = null;
        switch(type){
            case english:
                return b = english.getIns();
            case journal:
                return b= journal.getIns();
            case magzine:
                return b=magzine.getIns();
            case book:
                return new book();
            default:
                throw new UnsupportedOperationException("Unsupported!");
        }
    }

    @Override
    public readers getReader(Types type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public librarians getLibrarian(Types type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public transactions getTransaction(Types type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
