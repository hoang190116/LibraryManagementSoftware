/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.interfaces;

import Pattern.library.librarian.librarian;
import Pattern.library.librarian.librarianBuilder;
/**
 *
 * @author Admin
 */
public interface librarians {
    public librarian builder(librarianBuilder li);
    public String getPass();
    public String getName();
}
