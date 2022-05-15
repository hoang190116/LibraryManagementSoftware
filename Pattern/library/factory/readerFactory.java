/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.factory;

import Pattern.library.interfaces.books;
import Pattern.library.interfaces.librarians;
import Pattern.library.interfaces.readers;
import Pattern.library.interfaces.transactions;
import Pattern.library.reader.reader;

/**
 *
 * @author Admin
 */
public class readerFactory extends AbstractFactory{

    @Override
    public books getBook(Types type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public readers getReader(Types type) {
        switch(type){
            case reader:
                return reader.newIns();
             
            default:
                throw new UnsupportedOperationException("Unsupported!");
        }
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
