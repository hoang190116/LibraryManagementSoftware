/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.interfaces;

import Pattern.library.book.book;
import Pattern.library.book.bookBuilder;



/**
 *
 * @author Admin
 */
public interface books {
    public book builder(bookBuilder b);
    public int getBook_id();
    public String getBook_name();
    public String getAuthor();
    public String getPublish();
    public String getType();
    public String getArea();
}
