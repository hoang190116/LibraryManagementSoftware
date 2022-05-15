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



/**
 *
 * @author Admin
 */
public abstract class AbstractFactory {
    public abstract books getBook(Types type);
    public abstract readers getReader(Types type);
    public abstract librarians getLibrarian(Types type);
    public abstract transactions getTransaction(Types type);
    
    public static AbstractFactory getFactory(Types type){
        switch(type){
            case book:
                return new bookFactory();

            case librarian:
                return new librarianFactory();
             
            case reader:
                return new readerFactory();
            
            case transaction:
                return new librarianFactory();
                
            default:
                throw new UnsupportedOperationException("Unsupported!");
        }
    }
}
