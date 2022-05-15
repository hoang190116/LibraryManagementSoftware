/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.client;

import Pattern.library.book.book;
import Pattern.library.book.bookBuilder;
import Pattern.library.book.english;
import Pattern.library.book.journal;
import Pattern.library.factory.AbstractFactory;
import Pattern.library.factory.Types;
import Pattern.library.interfaces.books;
import Pattern.library.interfaces.librarians;
import Pattern.library.interfaces.readers;
import Pattern.library.librarian.librarian;
import Pattern.library.reader.reader;
import Pattern.library.transaction.transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class client {
    public static void main(String[] args) {
        english e = new english(1, "name", "author", "publish");
        System.out.println(e.getBook_id()+" "+e.getBook_name()+" "+e.getAuthor()+" "+e.getPublish()+" "+e.getType()
        +" "+e.getArea());
    }
}
