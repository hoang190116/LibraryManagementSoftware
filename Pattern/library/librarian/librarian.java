/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.librarian;


import Pattern.library.interfaces.librarians;

/**
 *
 * @author Admin
 */
public class librarian implements librarians{
    private static librarian l = null;
    private librarian(){
        
    }
    public static librarian getIns(){
        if(l==null){
            l = new librarian();
        }
        return l;
    }
    public static librarian newIns(){
        return new librarian();
    }
    private String name;
    private String pass;
    
    public librarian(String name, String pass){
        this.name = name;
        this.pass = pass;
    }
    
    @Override
    public librarian builder(librarianBuilder li){
        name = li.name;
        pass = li.pass;
        return this;
    }
    
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
