/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.book;
import Pattern.library.interfaces.books;
/**
 *
 * @author infor
 */
public class book implements books{
    private int Book_id;
    private String Book_name;
    private String Author;
    private String Publish;
    private String Type;
    private String Area;
    
    public book(){}
    
    @Override
    public book builder(bookBuilder b){
        if(b.book_id != null){
            this.Book_id = b.book_id;
        }
        this.Book_name = b.Book_name;
        this.Author = b.Author;
        this.Publish = b.Publish;
        this.Type = b.type;
        this.Area = b.area;
        return this;
    }

    @Override
    public int getBook_id() {
        return Book_id;
    }

    public void setBook_id(int Book_id) {
        this.Book_id = Book_id;
    }
    @Override
    public String getBook_name() {
        return Book_name;
    }

    public void setBook_name(String Book_name) {
        this.Book_name = Book_name;
    }
    @Override
    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }
    @Override
    public String getPublish() {
        return Publish;
    }

    public void setPublish(String Publish) {
        this.Publish = Publish;
    }
    @Override
    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    @Override
    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
    
}
