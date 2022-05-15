/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.book;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author infor
 */
public class magzine extends book {
    private static magzine m = null;
    private magzine(){
        
    }
    public static magzine getIns(){
        if(m == null){
            m = new magzine();
        }
        return m;
    }
    
    @Override
    public book builder(bookBuilder b) {
        super.builder(b);
        setArea("3");
        setType("magazine");
        return this;
    }
}
