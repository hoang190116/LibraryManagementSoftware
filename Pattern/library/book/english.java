/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.book;




/**
 *
 * @author infor
 */
public class english extends book{
    private static english e = null;
    private english(){
        
    }
    public english(int id, String name, String author, String publish){
        setBook_id(id);
        setBook_name(name);
        setAuthor(author);
        setPublish(publish);
        setArea("1");
        setType("english");
    }
    public static english getIns(){
        if(e == null){
            e=new english();
        }
        return e;
    }
    @Override
    public book builder(bookBuilder b) {
        super.builder(b);
        setArea("1");
        setType("english");
        return this;
    }
    
}
