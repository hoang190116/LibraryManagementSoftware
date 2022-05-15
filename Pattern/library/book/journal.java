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
public class journal extends book {
    private static journal j = null;
    private journal(){
        
    }
    public static journal getIns(){
        if(j==null){
            j = new journal();
        }
        return j;
    }
    
    @Override
    public book builder(bookBuilder b) {
        super.builder(b);
        setArea("2");
        setType("journal");
        return this;
    }
    
}
