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
import Pattern.library.librarian.librarian;
import Pattern.library.transaction.transaction;

/**
 *
 * @author Admin
 */
public class librarianFactory extends AbstractFactory{

    @Override
    public books getBook(Types type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public readers getReader(Types type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public librarians getLibrarian(Types type) {
        librarians li = null;
        switch(type){
            case librarian:
                return li = librarian.newIns();
             
            default:
                throw new UnsupportedOperationException("Unsupported!");
        }
    }

    @Override
    public transactions getTransaction(Types type) {
        transactions tr = null;
        switch(type){
            case transaction:
                return tr=transaction.newIns();
             
            default:
                throw new UnsupportedOperationException("Unsupported!");
        }
    }
    
}
