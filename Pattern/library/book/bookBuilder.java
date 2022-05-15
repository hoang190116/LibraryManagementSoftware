/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.book;

/**
 *
 * @author Admin
 */
public class bookBuilder {
    public Integer book_id;
    public String Book_name;
    public String Author;
    public String Publish;
    public String type;
    public String area;
    
    public bookBuilder book_id(int id){
        book_id = id;
        return this;
    }
    
    public bookBuilder book_name(String name){
        Book_name = name;
        return this;
    }
    
    public bookBuilder author(String name){
        Author = name;
        return this;
    }
    
    public bookBuilder publish(String name){
        Publish = name;
        return this;
    }
    
    public bookBuilder type(String name){
        type = name;
        return this;
    }
    
    public bookBuilder area(String name){
        area = name;
        return this;
    }
    
    public book build(){
        if(this.Book_name == null){
            this.Book_name = "None";
        }
        if(this.Author == null){
            this.Author="None";
        }
        if(this.Publish == null){
            this.Publish = "None";
        }
        book b = new book();
        return b.builder(this);
    }
}
