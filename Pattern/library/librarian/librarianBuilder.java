/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.librarian;

/**
 *
 * @author Admin
 */
public class librarianBuilder {
    public String name;
    public String pass;
    
    public librarianBuilder name(String name){
        this.name = name;
        return this;
    }
    
    public librarianBuilder pass(String name){
        pass = name;
        return this;
    }
    
    public librarian build(){
        return librarian.newIns().builder(this);
    }
}
