/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.library.reader;

/**
 *
 * @author Admin
 */
public class readerBuilder {
    public int readerID;
    public String name;
    public String pass;
    
    public readerBuilder readerID(int id){
        readerID = id;
        return this;
    }
    
    public readerBuilder name(String name){
        this.name = name;
        return this;
    }
    
    public readerBuilder pass(String name){
        pass = name;
        return this;
    }
    
    public reader build(){
        return reader.newIns().builder(this);
    }
}
