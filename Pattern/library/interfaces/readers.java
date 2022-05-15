/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.interfaces;

import Pattern.library.reader.reader;
import Pattern.library.reader.readerBuilder;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface readers {
    public reader builder(readerBuilder re);
    public int getReaderID();
    public String getName();
    public String getPass();
}
